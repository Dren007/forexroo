package com.github.xuzw.forexroo.activemq;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月6日 上午11:38:03
 */
public class ActiveMq {
    private static final Logger log = LoggerFactory.getLogger(ActiveMq.class);
    private static final String url = "failover:tcp://119.23.62.18:61616";
    private static final RequestCache requestCache = new RequestCache();
    private static final ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, url);

    public static void init() throws JMSException {
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        List<String> responseTopics = new ArrayList<>();
        responseTopics.add("History_Rates_Info_Result_Topic");
        new JsonResponseListener(session, requestCache, responseTopics);
    }

    public static void sendRequest(String topic, JSONObject jsonRequest, JsonResponseCallback callback) throws JMSException {
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createTopic(topic);
        MessageProducer messageProducer = session.createProducer(destination);
        messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        String requestId = requestCache.newRequestId();
        jsonRequest.put("reqid", requestId);
        requestCache.put(requestId, callback);
        BytesMessage bytesMessage = session.createBytesMessage();
        bytesMessage.writeBytes(jsonRequest.toJSONString().getBytes());
        messageProducer.send(bytesMessage);
        session.commit();
        session.close();
        connection.close();
    }

    public static JSONObject sendRequestAndAwait(String topic, JSONObject jsonRequest) throws InterruptedException {
        JSONObject future = new JSONObject();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sendRequest(topic, jsonRequest, new JsonResponseCallback() {
                        @Override
                        public void onMessage(JSONObject jsonResponse) {
                            for (String key : jsonResponse.keySet()) {
                                future.put(key, jsonResponse.get(key));
                            }
                            countDownLatch.countDown();
                        }
                    });
                } catch (JMSException e) {
                    log.error("", e);
                }
            }
        }).start();
        countDownLatch.await();
        return future;
    }
}
