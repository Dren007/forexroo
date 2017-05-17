package com.github.xuzw.forexroo.crm.div.login.input;

import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月15日 下午11:18:45
 */
@StyleAnnotation
public class Password extends Input {
    @Override
    protected void buildInput(HtmlBuilder input) {
        input.attr("type", "password").attr("placeholder", "请输入登录密码");
    }
}
