package com.mttch.admin.client.ui.main.center.services;

import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.ContentPanel;

public class XmppServicePanel extends ContentPanel {

    private XmppServiceGrid grid;

    @Inject
    public XmppServicePanel(XmppServiceGrid grid) {
        this.grid = grid;
        initUi();
    }

    private void initUi() {
        getHeader().setText("XMPP");
        add(grid);
    }

    public XmppServiceGrid getGrid() {
        return grid;
    }
}
