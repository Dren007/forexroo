package com.github.xuzw.forexroo.database.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月14日 下午12:38:52
 */
public class NamedValues {
    public static String toText(Enum<? extends NamedValue>[] namedValues) {
        List<String> list = new ArrayList<>();
        for (Enum<? extends NamedValue> x : namedValues) {
            NamedValue namedValue = (NamedValue) x;
            list.add(namedValue.toText());
        }
        return StringUtils.join(list, " ");
    }
}
