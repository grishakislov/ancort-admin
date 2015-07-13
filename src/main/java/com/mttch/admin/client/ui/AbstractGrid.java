package com.mttch.admin.client.ui;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.mttch.admin.common.StringConstants;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.client.loader.RpcProxy;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
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

import java.util.List;

public abstract class AbstractGrid<T> extends SimpleContainer {

    private Grid<T> grid;

    private PagingToolBar pagingToolBar;

    private ToolBar toolBar;

    private SimpleComboBox<Integer> comboBox = new SimpleComboBox<>(new StringLabelProvider<Integer>());

    public AbstractGrid() {
        build();
    }

    public void build() {
        RpcProxy<PagingLoadConfig, PagingLoadResult<T>> rpxProxy = new RpcProxy<PagingLoadConfig, PagingLoadResult<T>>() {
            @Override
            public void load(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<T>> callback) {
                handleRpc(loadConfig, callback);
            }
        };

        comboBox = createGridLimitCombobox(new SelectionHandler<Integer>() {
            @Override
            public void onSelection(SelectionEvent<Integer> event) {
                setLimit(event.getSelectedItem());
            }
        });

        ListStore<T> listStore = new ListStore<>(getModelKeyProvider());

        final PagingLoader<PagingLoadConfig, PagingLoadResult<T>> loader = new PagingLoader<>(rpxProxy);
        loader.setRemoteSort(true);
        loader.addLoadHandler(new LoadResultListStoreBinding<PagingLoadConfig, T, PagingLoadResult<T>>(listStore));

        //TODO: Hardcode, move to InitData
        pagingToolBar = new PagingToolBar(50);
        pagingToolBar.bind(loader);


        grid = new Grid<>(listStore, new ColumnModel<>(getColumnConfigs()));

        grid.setLoader(loader);
        grid.setLoadMask(true);
        grid.getView().setAutoFill(true);
        grid.getView().setStripeRows(true);
        grid.getView().setColumnLines(true);


        toolBar = new ToolBar();
        toolBar.add(new LabelToolItem(StringConstants.ROWS_PER_PAGE));
        toolBar.add(comboBox);

        VerticalLayoutContainer verticalLayoutContainer = new VerticalLayoutContainer();

        verticalLayoutContainer.add(toolBar, new VerticalLayoutContainer.VerticalLayoutData(1, -1));
        verticalLayoutContainer.add(grid, new VerticalLayoutContainer.VerticalLayoutData(1, 1));
        verticalLayoutContainer.add(pagingToolBar, new VerticalLayoutContainer.VerticalLayoutData(1, -1));
        add(verticalLayoutContainer);

    }

    protected abstract void handleRpc(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<T>> callback);

    protected abstract List<ColumnConfig<T, ?>> getColumnConfigs();

    protected abstract ModelKeyProvider<T> getModelKeyProvider();

    public void setLimit(int value) {
        pagingToolBar.setPageSize(value);
        pagingToolBar.refresh();
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

    protected ColumnConfig<T, ?> createColumnConfig(ValueProvider<T, ?> vp, int width, String header) {
        ColumnConfig<T, ?> config = new ColumnConfig<>(vp, width, header);
        config.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        return config;
    }

    public Grid<T> getGrid() {
        return grid;
    }

    public void refresh() {
        pagingToolBar.refresh();
    }

    public SimpleComboBox<Integer> getComboBox() {
        return comboBox;
    }

    public ToolBar getToolBar() {
        return toolBar;
    }


}
