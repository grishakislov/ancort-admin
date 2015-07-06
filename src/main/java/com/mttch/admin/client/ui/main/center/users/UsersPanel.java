package com.mttch.admin.client.ui.main.center.users;

import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.ContentPanel;


public class UsersPanel extends ContentPanel {

    UsersGrid usersGrid;

    @Inject
    public UsersPanel(UsersGrid usersGrid) {
        this.usersGrid = usersGrid;
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
