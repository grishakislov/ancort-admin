package com.mttch.admin.client.ui.main.center.administrators;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mttch.admin.client.server.administrator.AdministratorService;
import com.mttch.admin.client.server.administrator.AdministratorServiceAsync;
import com.mttch.admin.client.ui.AbstractGrid;
import com.mttch.admin.common.StringConstants;
import com.mttch.admin.common.model.grid.AdministratorModel;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;

import java.util.ArrayList;
import java.util.List;

public class AdministratorsGrid extends AbstractGrid<AdministratorModel> {

    private AdministratorProperties administratorProperties;

    @Override
    protected void handleRpc(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<AdministratorModel>> callback) {
        AdministratorServiceAsync service = AdministratorService.ServiceLoader.getInstance();
        service.listAdministrators(loadConfig, callback);
    }

    @Override
    protected List<ColumnConfig<AdministratorModel, ?>> getColumnConfigs() {
        List<ColumnConfig<AdministratorModel, ?>> result = new ArrayList<>();
        int size = 200;

        result.add(new ColumnConfig<>(administratorProperties.id(), size, StringConstants.AdministratorsGrid.ID));
        result.add(new ColumnConfig<>(administratorProperties.name(), size, StringConstants.AdministratorsGrid.NAME));
        result.add(new ColumnConfig<>(administratorProperties.online(), size, StringConstants.AdministratorsGrid.ONLINE));

        return result;
    }

    @Override
    protected ModelKeyProvider<AdministratorModel> getModelKeyProvider() {
        administratorProperties = GWT.create(AdministratorProperties.class);
        return administratorProperties.key();
    }
}
