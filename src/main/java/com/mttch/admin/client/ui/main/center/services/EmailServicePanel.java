package com.mttch.admin.client.ui.main.center.services;

import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.ContentPanel;

public class EmailServicePanel extends ContentPanel {

    private EmailServiceGrid grid;

    @Inject
    public EmailServicePanel(EmailServiceGrid grid) {
        this.grid = grid;
        initUi();
    }

    private void initUi() {
        getHeader().setText("Почта");
        add(grid);
    }

    public EmailServiceGrid getGrid() {
        return grid;
    }
}
