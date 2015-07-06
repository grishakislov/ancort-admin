package com.mttch.admin.client.ui.main.center.administrators;

import com.google.inject.Inject;
import com.mttch.admin.client.utils.UiFactory;
import com.mttch.admin.common.StringConstants;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;

public class AdministratorsPanel extends ContentPanel {

    private AdministratorsGrid grid;
    private TextButton loadAdministratorsButton;

    @Inject
    public AdministratorsPanel(AdministratorsGrid administratorsGrid) {
        grid = administratorsGrid;
        initUi();
    }

    private void initUi() {
        loadAdministratorsButton = new TextButton(StringConstants.AdministratorsGrid.ADD_ADMINISTRATOR_BUTTON);
        loadAdministratorsButton.setWidth(180);
        grid.getToolBar().add(UiFactory.createHorizontalSpacer(30));
        grid.getToolBar().add(loadAdministratorsButton);

        //TODO: Hardcode
        getHeader().setText("Администраторы");
        add(grid);
    }

    public AdministratorsGrid getAdministratorsGrid() {
        return grid;
    }

    public TextButton getLoadAdministratorsButton() {
        return loadAdministratorsButton;
    }
}
