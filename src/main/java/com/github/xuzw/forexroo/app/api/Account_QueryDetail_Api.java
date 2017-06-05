package com.github.xuzw.forexroo.app.api;

import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "账户 - 查询详情")
@GenerateByApiEngineSdk(time = "2017.06.05 05:03:00.819", version = "v0.0.25")
public class Account_QueryDetail_Api implements Api {

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
    }

    public static class Resp extends Response {

        @Comment(value = "用户唯一标识码")
        @Required(value = true)
        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        @Comment(value = "Forexroo账号")
        @Required(value = true)
        private String account;

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        @Comment(value = "MT4真实账号")
        @Required(value = true)
        private String mt4RealAccount;

        public String getMt4RealAccount() {
            return mt4RealAccount;
        }

        public void setMt4RealAccount(String mt4RealAccount) {
            this.mt4RealAccount = mt4RealAccount;
        }

        @Comment(value = "MT4模拟账号")
        @Required(value = true)
        private String mt4AnalogAccount;

        public String getMt4AnalogAccount() {
            return mt4AnalogAccount;
        }

        public void setMt4AnalogAccount(String mt4AnalogAccount) {
            this.mt4AnalogAccount = mt4AnalogAccount;
        }

        @Comment(value = "净值")
        @Required(value = true)
        private String balance;

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        @Comment(value = "信用")
        @Required(value = true)
        private String credit;

        public String getCredit() {
            return credit;
        }

        public void setCredit(String credit) {
            this.credit = credit;
        }

        @Comment(value = "利率")
        @Required(value = true)
        private String interestrate;

        public String getInterestrate() {
            return interestrate;
        }

        public void setInterestrate(String interestrate) {
            this.interestrate = interestrate;
        }

        @Comment(value = "税金")
        @Required(value = true)
        private String taxes;

        public String getTaxes() {
            return taxes;
        }

        public void setTaxes(String taxes) {
            this.taxes = taxes;
        }

        @Comment(value = "杠杆率")
        @Required(value = true)
        private String leverage;

        public String getLeverage() {
            return leverage;
        }

        public void setLeverage(String leverage) {
            this.leverage = leverage;
        }
    }
}
