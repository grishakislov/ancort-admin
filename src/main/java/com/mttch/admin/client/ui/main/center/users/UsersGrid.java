package com.mttch.admin.client.ui.main.center.users;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mttch.admin.client.callback.ServerCallback;
import com.mttch.admin.client.server.user.UserService;
import com.mttch.admin.client.server.user.UserServiceAsync;
import com.mttch.admin.common.StringConstants;
import com.mttch.admin.common.model.grid.UserModel;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.data.client.loader.RpcProxy;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.SimpleComboBox;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.toolbar.LabelToolItem;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;

import java.util.ArrayList;
import java.util.List;

//TODO: move to AbstractGrid
public class UsersGrid extends SimpleContainer {

    private UserProperties userProperties = GWT.create(UserProperties.class);
    private Grid<UserModel> grid;
    private PagingToolBar pagingToolBar;

    private SimpleComboBox<Integer> comboBox = new SimpleComboBox<>(new StringLabelProvider<Integer>());

    public UsersGrid() {
        initUi();
    }

    private void initUi() {
        RpcProxy<PagingLoadConfig, PagingLoadResult<UserModel>> rpxProxy = new RpcProxy<PagingLoadConfig, PagingLoadResult<UserModel>>() {
            @Override
            public void load(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<UserModel>> callback) {
                UserServiceAsync service = UserService.ServiceLoader.getInstance();
                service.listUsers(loadConfig, callback);
            }
        };

        ListStore<UserModel> listStore = createListStore();

        final PagingLoader<PagingLoadConfig, PagingLoadResult<UserModel>> loader = new PagingLoader<>(rpxProxy);
        loader.setRemoteSort(true);
        loader.addLoadHandler(new LoadResultListStoreBinding<PagingLoadConfig, UserModel, PagingLoadResult<UserModel>>(listStore));

        //TODO: Hardcode, move to InitData
        pagingToolBar = new PagingToolBar(50);
        pagingToolBar.bind(loader);

        comboBox = createGridLimitCombobox(new SelectionHandler<Integer>() {
            @Override
            public void onSelection(SelectionEvent<Integer> event) {
                setLimit(event.getSelectedItem());
            }
        });

        grid = new Grid<>(listStore, createColumnModel());
        grid.setLoader(loader);
        grid.getView().setAutoFill(true);


        ToolBar toolBar = new ToolBar();
        toolBar.add(new LabelToolItem("Page row limit: "));
        toolBar.add(comboBox);


        VerticalLayoutContainer verticalLayoutContainer = new VerticalLayoutContainer();

        verticalLayoutContainer.add(toolBar, new VerticalLayoutContainer.VerticalLayoutData(1, -1));
        verticalLayoutContainer.add(grid, new VerticalLayoutContainer.VerticalLayoutData(1, 1));
        verticalLayoutContainer.add(pagingToolBar, new VerticalLayoutContainer.VerticalLayoutData(1, -1));
        add(verticalLayoutContainer);
    }

    public void setLimit(int value) {
        pagingToolBar.setPageSize(value);
        pagingToolBar.refresh();
    }

    private ListStore<UserModel> createListStore() {
        ListStore<UserModel> store = new ListStore<>(userProperties.key());

        return store;
    }

    private SimpleComboBox<Integer> createGridLimitCombobox(SelectionHandler<Integer> selectionHandler) {
        SimpleComboBox<Integer> combo = new SimpleComboBox<>(new StringLabelProvider<Integer>());
        combo.setTriggerAction(ComboBoxCell.TriggerAction.ALL);
        combo.setEditable(false);
        combo.setWidth(100);
        combo.add(50);
        combo.add(100);
        combo.add(250);
        combo.add(500);
        combo.setValue(50);
        combo.addSelectionHandler(selectionHandler);
        return combo;
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

    public void refresh() {
        grid.getLoader().load();
    }

    public SimpleComboBox<Integer> getComboBox() {
        return comboBox;
    }
}
