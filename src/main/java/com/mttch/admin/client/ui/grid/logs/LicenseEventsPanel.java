package com.mttch.admin.client.ui.grid.logs;

import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.ContentPanel;

public class LicenseEventsPanel extends ContentPanel {

    private LicenseEventsGrid grid;

    @Inject
    public LicenseEventsPanel(LicenseEventsGrid grid) {
        this.grid = grid;
        initUi();
    }

    private void initUi() {
        getHeader().setText("Лог лицензий");
        add(grid);
    }

    public LicenseEventsGrid getGrid() {
        return grid;
    }
}
