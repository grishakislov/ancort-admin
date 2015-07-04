package com.mttch.admin.client.ui.main.center.users;

import com.google.gwt.core.client.GWT;
import com.mttch.admin.common.StringConstants;
import com.mttch.admin.common.model.grid.UserModel;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

import java.util.ArrayList;
import java.util.List;

public class UsersGrid extends SimpleContainer {

    private UserProperties userProperties = GWT.create(UserProperties.class);
    private Grid<UserModel> grid;

    public UsersGrid() {
        initUi();
    }

    private void initUi() {
        grid = new Grid<>(createListStore(), createColumnModel());
        grid.getView().setAutoFill(true);
//        grid.getView().setForceFit(true);
        add(grid);
    }

    private ListStore<UserModel> createListStore() {
        ListStore<UserModel> store = new ListStore<>(userProperties.key());

        return store;
    }

    private ColumnModel<UserModel> createColumnModel() {
        ColumnModel<UserModel> columnModel = new ColumnModel<>(createColumnConfig());
        return columnModel;
    }

    private List<ColumnConfig<UserModel, ?>> createColumnConfig() {
        int size = 200;
        ColumnConfig<UserModel, String> createDateCol = new ColumnConfig<>(userProperties.createDate(), size, StringConstants.UserGrid.CREATE_DATE);
        ColumnConfig<UserModel, String> receiveDateCol = new ColumnConfig<>(userProperties.receiveDate(), size, StringConstants.UserGrid.RECEIVE_DATE);
        ColumnConfig<UserModel, String> firstQueryDateCol = new ColumnConfig<>(userProperties.firstQueryDate(), size, StringConstants.UserGrid.FIRST_QUERY_DATE);
        ColumnConfig<UserModel, Integer> cryptoNumberCol = new ColumnConfig<>(userProperties.cryptoNumber(), size, StringConstants.UserGrid.CRYPTO_NUMBER);
        ColumnConfig<UserModel, String> loginCol = new ColumnConfig<>(userProperties.login(), size, StringConstants.UserGrid.LOGIN);
        ColumnConfig<UserModel, String> deviceIdCol = new ColumnConfig<>(userProperties.deviceId(), size, StringConstants.UserGrid.DEVICE_ID);
        ColumnConfig<UserModel, String> platformCol = new ColumnConfig<>(userProperties.platform(), size, StringConstants.UserGrid.PLATFORM);
        ColumnConfig<UserModel, String> pushTokenCol = new ColumnConfig<>(userProperties.pushToken(), size, StringConstants.UserGrid.PUSH_TOKEN);
        ColumnConfig<UserModel, Integer> licenseCol = new ColumnConfig<>(userProperties.license(), size, StringConstants.UserGrid.LICENSE);
        ColumnConfig<UserModel, Integer> linkTableCol = new ColumnConfig<>(userProperties.linkTable(), size, StringConstants.UserGrid.LINK_TABLE);

        List<ColumnConfig<UserModel, ?>> result = new ArrayList<>();
        result.add(createDateCol);
        result.add(receiveDateCol);
        result.add(firstQueryDateCol);
        result.add(cryptoNumberCol);
        result.add(loginCol);
        result.add(deviceIdCol);
        result.add(platformCol);
        result.add(pushTokenCol);
        result.add(licenseCol);
        result.add(linkTableCol);
        return result;
    }

    public Grid<UserModel> getGrid() {
        return grid;
    }
}
