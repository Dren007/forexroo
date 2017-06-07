package com.github.xuzw.forexroo.app.api;

import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "我关注的交易大师 - 添加")
@GenerateByApiEngineSdk(time = "2017.06.07 09:29:16.036", version = "v0.0.29")
public class MyMasterTrader_Add_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Response resp = new Response();
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "用户唯一标识码")
        @Required(value = true)
        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        @Comment(value = "交易大师ID")
        @Required(value = true)
        private Long masterTraderUserId;

        public Long getMasterTraderUserId() {
            return masterTraderUserId;
        }

        public void setMasterTraderUserId(Long masterTraderUserId) {
            this.masterTraderUserId = masterTraderUserId;
        }
    }
}
