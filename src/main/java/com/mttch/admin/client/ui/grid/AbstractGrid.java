package com.mttch.admin.client.ui.grid;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.mttch.admin.client.AppContext;
import com.mttch.admin.common.StringConstants;
import com.mttch.admin.common.exception.BusinessException;
import com.mttch.admin.common.model.grid.BaseGridModel;
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

public abstract class AbstractGrid<T extends BaseGridModel> extends SimpleContainer {

    private Grid<T> grid;

    private PagingToolBar pagingToolBar;

    private ToolBar toolBar;

    private SimpleComboBox<Integer> gridLimitComboBox = new SimpleComboBox<>(new StringLabelProvider<Integer>());

    protected abstract void handleRpc(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<T>> callback);

    protected abstract List<ColumnConfig<T, ?>> getColumnConfigs();

    protected abstract ModelKeyProvider<T> getModelKeyProvider();

    protected GridSettings getGridSettings() {
        return new GridSettings(true, true);
    }

    public AbstractGrid() {
        build();
    }

    protected void build() {
        RpcProxy<PagingLoadConfig, PagingLoadResult<T>> rpxProxy = new RpcProxy<PagingLoadConfig, PagingLoadResult<T>>() {
            @Override
            public void load(PagingLoadConfig loadConfig, final AsyncCallback<PagingLoadResult<T>> callback) {
                handleRpc(loadConfig, new AsyncCallback<PagingLoadResult<T>>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        if (caught instanceof BusinessException) {
                            AppContext.handleBusinessException((BusinessException) caught);
                        }
                        callback.onFailure(caught);
                    }

                    @Override
                    public void onSuccess(PagingLoadResult<T> result) {
                        callback.onSuccess(result);
                    }
                });
            }
        };

        gridLimitComboBox = createGridLimitComboBox(new SelectionHandler<Integer>() {
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
        toolBar.add(gridLimitComboBox);

        VerticalLayoutContainer verticalLayoutContainer = new VerticalLayoutContainer();

        if (getGridSettings().isShowGridLimitComboBox()) {
            verticalLayoutContainer.add(toolBar, new VerticalLayoutContainer.VerticalLayoutData(1, -1));
        }

        verticalLayoutContainer.add(grid, new VerticalLayoutContainer.VerticalLayoutData(1, 1));

        if (getGridSettings().isShowPagingToolbar()) {
            verticalLayoutContainer.add(pagingToolBar, new VerticalLayoutContainer.VerticalLayoutData(1, -1));
        }

        add(verticalLayoutContainer);
    }

    private SimpleComboBox<Integer> createGridLimitComboBox(SelectionHandler<Integer> selectionHandler) {
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

/*
    protected ColumnConfig<T, ?> createColumnConfig(ValueProvider<T, ?> vp, int width, String header, boolean wordWrap) {
        ColumnConfig<T, ?> columnConfig = createColumnConfig(vp, width, header);
        if (wordWrap) {
            SafeStyles s = new SafeStyles() {
                @Override
                public String asString() {
                    return "white-space:normal";
                }
            };
            columnConfig.setColumnStyle(s);
        }
        return columnConfig;
    }
*/

    protected ColumnConfig<T, ?> createColumnConfig(ValueProvider<T, ?> vp, int width, String header) {
        ColumnConfig<T, ?> config = new ColumnConfig<>(vp, width, header);
        config.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        return config;
    }

    public void setLimit(int value) {
        pagingToolBar.setPageSize(value);
        pagingToolBar.refresh();
    }

    public Grid<T> getGrid() {
        return grid;
    }

    public void refresh() {
        pagingToolBar.refresh();
    }

    public SimpleComboBox<Integer> getGridLimitComboBox() {
        return gridLimitComboBox;
    }

    public ToolBar getToolBar() {
        return toolBar;
    }


}
