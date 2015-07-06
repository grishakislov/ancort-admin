package com.mttch.admin.client.ui.main.center.users;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.text.shared.AbstractSafeHtmlRenderer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.mttch.admin.client.server.user.UserService;
import com.mttch.admin.client.server.user.UserServiceAsync;
import com.mttch.admin.client.ui.AbstractGrid;
import com.mttch.admin.common.StringConstants;
import com.mttch.admin.common.model.grid.AdministratorModel;
import com.mttch.admin.common.model.grid.UserModel;
import com.sencha.gxt.cell.core.client.TextButtonCell;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.core.client.resources.CommonStyles;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.editing.GridEditing;
import com.sencha.gxt.widget.core.client.grid.editing.GridRowEditing;

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

    protected GridEditing<UserModel> createGridEditing(Grid<UserModel> editableGrid) {
        GridRowEditing<UserModel> rowEditing = new GridRowEditing<UserModel>(editableGrid);
        return rowEditing;
    }


    @Override
    protected List<ColumnConfig<UserModel, ?>> getColumnConfigs() {
        int size = 200;
        ValueProvider<UserModel, String> buttonValue = new ValueProvider<UserModel, String>() {
            @Override
            public String getValue(UserModel object) {
                return "x";
            }
            @Override
            public void setValue(UserModel object, String value) {}

            @Override
            public String getPath() {return null;}
        };

        ColumnConfig<UserModel, String> buttonColumn =
                new ColumnConfig<>(buttonValue, 60, "X");
        deleteButton = new TextButtonCell();
        deleteButton.setHeight(20);
        buttonColumn.setColumnTextClassName(CommonStyles.get().inlineBlock());
        buttonColumn.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        buttonColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        buttonColumn.setCell(deleteButton);

        List<ColumnConfig<UserModel, ?>> result = new ArrayList<>();
        result.add(buttonColumn);
        result.add(createColumnConfig(userProperties.login(), size, StringConstants.UserGrid.LOGIN));
        result.add(createColumnConfig(userProperties.createDate(), size, StringConstants.UserGrid.CREATE_DATE));
        result.add(createColumnConfig(userProperties.receiveDate(), size, StringConstants.UserGrid.RECEIVE_DATE));
        result.add(createColumnConfig(userProperties.firstQueryDate(), size, StringConstants.UserGrid.FIRST_QUERY_DATE));
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
