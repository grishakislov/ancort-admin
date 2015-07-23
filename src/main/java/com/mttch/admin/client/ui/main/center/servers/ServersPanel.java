package com.mttch.admin.client.ui.main.center.servers;

import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.ContentPanel;

public class ServersPanel extends ContentPanel {

    private MailServersGrid grid;

    @Inject
    public ServersPanel(MailServersGrid mailServersGrid) {
        this.grid = mailServersGrid;
        initUi();
    }

    private void initUi() {
        getHeader().setText("Серверы");
        add(grid);
    }

    public MailServersGrid getGrid() {
        return grid;
    }
}
