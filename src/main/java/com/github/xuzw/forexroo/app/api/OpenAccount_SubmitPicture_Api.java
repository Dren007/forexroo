package com.github.xuzw.forexroo.app.api;

import static com.github.xuzw.forexroo.entity.Tables.USER;
import java.util.HashMap;
import java.util.Map;
import org.jooq.Field;
import org.jooq.impl.DSL;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.exception.ApiExecuteException;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.database.Jooq;
import com.github.xuzw.forexroo.entity.tables.daos.UserDao;
import com.github.xuzw.forexroo.entity.tables.pojos.User;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "开户 - 第二步：提交手持身份证正面照（URL）")
@GenerateByApiEngineSdk(time = "2017.06.15 11:39:47.858", version = "v1.0.1")
public class OpenAccount_SubmitPicture_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        String token = req.getToken();
        UserDao userDao = new UserDao(Jooq.buildConfiguration());
        User user = userDao.fetchOne(USER.TOKEN, token);
        if (user == null) {
            throw new ApiExecuteException(ErrorCodeEnum.token_error);
        }
        Map<Field<?>, Object> map = new HashMap<>();
        map.put(USER.OPEN_ACCOUNT_PICTURE_URL, req.getPictureUrl());
        DSL.using(Jooq.buildConfiguration()).update(USER).set(map).where(USER.TOKEN.equal(token)).execute();
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

        @Comment(value = "手持身份证正面照URL")
        @Required(value = true)
        private String pictureUrl;

        public String getPictureUrl() {
            return pictureUrl;
        }

        public void setPictureUrl(String pictureUrl) {
            this.pictureUrl = pictureUrl;
        }
    }
}
