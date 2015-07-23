package com.mttch.admin.client.ui.grid;

public class GridProperties {

    private boolean showPagingToolbar;
    private boolean showGridLimitComboBox;

    public GridProperties(boolean showPagingToolbar, boolean showGridLimitComboBox) {
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
