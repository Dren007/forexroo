package com.github.xuzw.forexroo.app.api;

import static com.github.xuzw.forexroo.entity.Tables.MY_MASTER_TRADER;
import static com.github.xuzw.forexroo.entity.Tables.USER;
import org.jooq.impl.DSL;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.database.Jooq;
import com.github.xuzw.forexroo.entity.tables.daos.UserDao;
import com.github.xuzw.forexroo.entity.tables.pojos.User;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "我关注的交易大师 - 删除")
@GenerateByApiEngineSdk(time = "2017.06.15 03:28:54.134", version = "v1.0.4")
public class MyMasterTrader_Delete_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        UserDao userDao = new UserDao(Jooq.buildConfiguration());
        User user = userDao.fetchOne(USER.TOKEN, req.getToken());
        DSL.using(Jooq.buildConfiguration()).delete(MY_MASTER_TRADER).where(MY_MASTER_TRADER.USER_ID.equal(user.getId())).and(MY_MASTER_TRADER.MASTER_TRADER_USER_ID.equal(req.getMasterTraderUserId())).execute();
        return new Response();
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
