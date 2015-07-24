package com.mttch.admin.client.ui.grid.logs;

import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.ContentPanel;

public class AdminLogPanel extends ContentPanel {

    private AdminLogGrid grid;

    @Inject
    public AdminLogPanel(AdminLogGrid grid) {
        this.grid = grid;
        initUi();
    }

    private void initUi() {
        getHeader().setText("Лог администратора");
        add(grid);
    }

    public AdminLogGrid getGrid() {
        return grid;
    }
}
