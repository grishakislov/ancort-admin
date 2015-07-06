package com.mttch.admin.client.utils;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;

public class UiFactory {

    public static Widget createHorizontalSpacer(int width) {
        SimpleContainer simpleContainer = new SimpleContainer();
        simpleContainer.setWidth(width);
        return simpleContainer;
    }

    public static Widget createVerticalSpacer(int height) {
        SimpleContainer simpleContainer = new SimpleContainer();
        simpleContainer.setHeight(height);
        return simpleContainer;
    }

    public static Widget createWhiteLabel(String text, int sizePx) {
        String style =
                "color: white; " +
                        "font-family: helvetica,arial,verdana,sans-serif;" +
                        "font-weight: bold" +
                        "font-size: " + sizePx + "px";
        HTML htmlLabel = new HTML("<span style='" + style + "'>" + text + "</span>");
        return htmlLabel;
    }

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
