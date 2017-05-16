package com.github.xuzw.forexroo.crm.engine;

import java.util.List;

import com.github.xuzw.forexroo.crm.div.Background;
import com.github.xuzw.forexroo.crm.div.login.container.LoginForm;
import com.github.xuzw.ui_engine_runtime.impl.SimpleUiEngine;
import com.github.xuzw.ui_engine_runtime.page.builder.PageBuilder;
import com.github.xuzw.ui_engine_runtime.script.ExternalScript;
import com.github.xuzw.ui_engine_runtime.style.ExternalStyleSheet;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月15日 下午4:51:12
 */
public class CrmWebUiEngine extends SimpleUiEngine {
    public CrmWebUiEngine(List<ExternalStyleSheet> externalStyleSheets, List<ExternalScript> externalScripts) {
        setExternalStyleSheets(externalStyleSheets);
        setExternalScripts(externalScripts);
        setPage("login", new PageBuilder("登录").body(new Background(new LoginForm())).build());
    }
}