package com.mttch.admin.client.ui.main.center.administrators;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.mttch.admin.client.server.administrator.AdministratorService;
import com.mttch.admin.client.server.administrator.AdministratorServiceAsync;
import com.mttch.admin.client.ui.AbstractGrid;
import com.mttch.admin.common.StringConstants;
import com.mttch.admin.common.model.grid.AdministratorModel;
import com.sencha.gxt.cell.core.client.TextButtonCell;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.core.client.resources.CommonStyles;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;

import java.util.ArrayList;
import java.util.List;

public class AdministratorsGrid extends AbstractGrid<AdministratorModel> {

    private AdministratorProperties administratorProperties;

    private TextButtonCell deleteButton;

    @Override
    protected void handleRpc(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<AdministratorModel>> callback) {
        AdministratorServiceAsync service = AdministratorService.ServiceLoader.getInstance();
        service.listAdministrators(loadConfig, callback);
    }

    @Override
    protected List<ColumnConfig<AdministratorModel, ?>> getColumnConfigs() {
        List<ColumnConfig<AdministratorModel, ?>> result = new ArrayList<>();
        int size = 200;

        result.add(createColumnConfig(administratorProperties.id(), size, StringConstants.AdministratorsGrid.ID));
        result.add(createColumnConfig(administratorProperties.name(), size, StringConstants.AdministratorsGrid.NAME));
        result.add(createColumnConfig(administratorProperties.online(), size, StringConstants.AdministratorsGrid.ONLINE));

        ValueProvider<AdministratorModel, String> buttonValue = new ValueProvider<AdministratorModel, String>() {
            @Override
            public String getValue(AdministratorModel object) {
                return "  " + StringConstants.AdministratorsGrid.DELETE_ADMIN + "  ";
            }
            @Override
            public void setValue(AdministratorModel object, String value) {}

            @Override
            public String getPath() {return null;}
        };

        ColumnConfig<AdministratorModel, String> buttonColumn =
                new ColumnConfig<>(buttonValue, size, StringConstants.AdministratorsGrid.DELETE);

        deleteButton = new TextButtonCell();
        buttonColumn.setColumnTextClassName(CommonStyles.get().inlineBlock());
        buttonColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        buttonColumn.setCell(deleteButton);
        result.add(buttonColumn);

        return result;
    }

    @Override
    protected ModelKeyProvider<AdministratorModel> getModelKeyProvider() {
        administratorProperties = GWT.create(AdministratorProperties.class);
        return administratorProperties.key();
    }

    public TextButtonCell getDeleteButton() {
        return deleteButton;
    }
}
