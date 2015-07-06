package com.mttch.admin.client.ui.main.center.users;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mttch.admin.client.server.user.UserService;
import com.mttch.admin.client.server.user.UserServiceAsync;
import com.mttch.admin.client.ui.AbstractGrid;
import com.mttch.admin.common.StringConstants;
import com.mttch.admin.common.model.grid.UserModel;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;

import java.util.ArrayList;
import java.util.List;

public class UsersGrid extends AbstractGrid<UserModel> {

    private UserProperties userProperties;

    @Override
    protected ModelKeyProvider<UserModel> getModelKeyProvider() {
        userProperties = GWT.create(UserProperties.class);
        return userProperties.key();
    }

    @Override
    protected void handleRpc(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<UserModel>> callback) {
        UserServiceAsync service = UserService.ServiceLoader.getInstance();
        service.listUsers(loadConfig, callback);
    }

    @Override
    protected List<ColumnConfig<UserModel, ?>> getColumnConfigs() {
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

}
