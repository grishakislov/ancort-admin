package com.mttch.admin.client.ui.grid;

public class GridSettings {

    private boolean showPagingToolbar;
    private boolean showGridLimitComboBox;

    public GridSettings(boolean showPagingToolbar, boolean showGridLimitComboBox) {
        this.showPagingToolbar = showPagingToolbar;
        this.showGridLimitComboBox = showGridLimitComboBox;
    }

    public boolean isShowPagingToolbar() {
        return showPagingToolbar;
    }

    public boolean isShowGridLimitComboBox() {
        return showGridLimitComboBox;
    }
}
