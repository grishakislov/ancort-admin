package com.mttch.admin.client.ui.main;

import com.mttch.admin.client.ui.UiColors;
import com.sencha.gxt.widget.core.client.ContentPanel;

public class WebAppRootPanel extends ContentPanel {

    public WebAppRootPanel() {
        setHeaderVisible(false);

        //TODO: Check in Firefox
        setBodyStyle("background-color: " + UiColors.LIGHT_BLUE);
    }
}
