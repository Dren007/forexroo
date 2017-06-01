package com.github.xuzw.forexroo.app.api;

import com.github.xuzw.api_engine_runtime.api.ResponseCode;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;

@GenerateByApiEngineSdk(time = "2017.06.01 03:37:38.768", version = "v0.0.5")
public enum ErrorCodeEnum implements ResponseCode {

    /**数据库异常*/
    database_error(1000, "数据库异常"), /**资源不存在或已被删除*/
    not_exists(1001, "资源不存在或已被删除"), /**验证码发送失败*/
    sms_send_error(1002, "验证码发送失败"), /**验证码错误*/
    verification_code_error(1003, "验证码错误"), /**用户唯一标识码错误*/
    token_error(1004, "用户唯一标识码错误"), /**姓名和身份证号不匹配*/
    realName_identityCardNumber_not_match(1005, "姓名和身份证号不匹配");

    private ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private final int code;

    public int getCode() {
        return code;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
