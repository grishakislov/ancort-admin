package com.mttch.admin.client.utils;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class LabelHelper {

    public static Widget createWhiteLabel(String text) {
        String style =
                "color: white; " +
                        "font-family: helvetica,arial,verdana,sans-serif;" +
                        "font-weight: bold" +
                        "font-size: 12px";
        HTML htmlLabel = new HTML("<span style='" + style + "'>" + text + "</span>");
        return htmlLabel;
    }


}
