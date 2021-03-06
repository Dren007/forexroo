package com.github.xuzw.forexroo.app.api;

import com.github.xuzw.api_engine_runtime.annotation.ModelAnnotation;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@ModelAnnotation()
@GenerateByApiEngineSdk(time = "2017.06.16 02:57:35.756", version = "v1.0.7")
public class MasterTraderProfit {

    @Comment(value = "盈亏总额")
    @Required(value = true)
    private Long profit;

    public Long getProfit() {
        return profit;
    }

    public void setProfit(Long profit) {
        this.profit = profit;
    }

    @Comment(value = "盈亏比例")
    @Required(value = true)
    private String profitRate;

    public String getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(String profitRate) {
        this.profitRate = profitRate;
    }
}
