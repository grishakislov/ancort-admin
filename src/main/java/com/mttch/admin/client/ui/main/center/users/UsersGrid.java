package com.mttch.admin.client.ui.main.center.users;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mttch.admin.client.server.user.UserService;
import com.mttch.admin.client.server.user.UserServiceAsync;
import com.mttch.admin.client.ui.grid.AbstractGrid;
import com.mttch.admin.client.utils.UiFactory;
import com.mttch.admin.common.StringConstants;
import com.mttch.admin.common.model.grid.UserModel;
import com.sencha.gxt.cell.core.client.TextButtonCell;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;

import java.util.ArrayList;
import java.util.List;

public class UsersGrid extends AbstractGrid<UserModel> {

    private UserProperties userProperties;
    private TextButtonCell deleteButton;

    public UsersGrid() {
        super();
    }

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

        List<ColumnConfig<UserModel, ?>> result = new ArrayList<>();
        deleteButton = new TextButtonCell();
        result.add(UiFactory.createDeleteButtonColumn(UserModel.class, deleteButton));
        result.add(createColumnConfig(userProperties.login(), size, StringConstants.UserGrid.LOGIN));
        result.add(createColumnConfig(userProperties.createDate(), size, StringConstants.UserGrid.CREATE_DATE));
        result.add(createColumnConfig(userProperties.receiveDate(), size, StringConstants.UserGrid.RECEIVE_DATE));
        result.add(createColumnConfig(userProperties.firstRequestDate(), size, StringConstants.UserGrid.FIRST_QUERY_DATE));
        result.add(createColumnConfig(userProperties.cryptoNumber(), size, StringConstants.UserGrid.CRYPTO_NUMBER));
        result.add(createColumnConfig(userProperties.deviceId(), size, StringConstants.UserGrid.DEVICE_ID));
        result.add(createColumnConfig(userProperties.platform(), size, StringConstants.UserGrid.PLATFORM));
        result.add(createColumnConfig(userProperties.pushToken(), size, StringConstants.UserGrid.PUSH_TOKEN));
        result.add(createColumnConfig(userProperties.license(), size, StringConstants.UserGrid.LICENSE));
        result.add(createColumnConfig(userProperties.linkTable(), size, StringConstants.UserGrid.LINK_TABLE));
        return result;
    }

    public TextButtonCell getDeleteButton() {
        return deleteButton;
    }
}
