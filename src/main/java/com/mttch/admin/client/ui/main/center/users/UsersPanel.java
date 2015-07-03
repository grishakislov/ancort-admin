package com.mttch.admin.client.ui.main.center.users;

import com.google.inject.Inject;
import com.mttch.admin.client.AppContext;
import com.sencha.gxt.widget.core.client.ContentPanel;

public class UsersPanel extends ContentPanel {

    UsersGrid usersGrid;

    public UsersPanel() {
        this.usersGrid = AppContext.injector.getUsersGrid();
        initUi();
    }

    private void initUi() {
        getHeader().setText("Пользователи");
        add(usersGrid);
    }

    public UsersGrid getUsersGrid() {
        return usersGrid;
    }
}
