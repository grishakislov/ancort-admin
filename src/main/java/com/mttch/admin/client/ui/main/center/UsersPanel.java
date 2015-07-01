package com.mttch.admin.client.ui.main.center;

import com.sencha.gxt.widget.core.client.ContentPanel;

public class UsersPanel extends ContentPanel {

    public UsersPanel() {
        initUi();
    }

    private void initUi() {
        getHeader().setText("Пользователи");
    }
}
