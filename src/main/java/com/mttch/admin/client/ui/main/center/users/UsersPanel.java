package com.mttch.admin.client.ui.main.center.users;

import com.google.inject.Inject;
import com.mttch.admin.client.utils.UiFactory;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;


public class UsersPanel extends ContentPanel {

    UsersGrid usersGrid;
    TextButton loadLicensesButton;

    @Inject
    public UsersPanel(UsersGrid usersGrid) {
        this.usersGrid = usersGrid;
        loadLicensesButton = new TextButton("Загрузить лицензии");
        loadLicensesButton.setWidth(170);
        usersGrid.getToolBar().add(UiFactory.createHorizontalSpacer(30));
        usersGrid.getToolBar().add(loadLicensesButton);

        initUi();
    }

    private void initUi() {
        getHeader().setText("Пользователи");
        add(usersGrid);
    }

    public UsersGrid getUsersGrid() {
        return usersGrid;
    }

    public TextButton getLoadLicensesButton() {
        return loadLicensesButton;
    }
}
