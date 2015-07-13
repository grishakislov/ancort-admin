package com.mttch.admin.client.ui.main.center.logs;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mttch.admin.client.server.log.LogService;
import com.mttch.admin.client.server.log.LogServiceAsync;
import com.mttch.admin.client.ui.AbstractGrid;
import com.mttch.admin.common.StringConstants;
import com.mttch.admin.common.model.grid.log.LicenseLogModel;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;

import java.util.ArrayList;
import java.util.List;

public class LicenseEventsGrid extends AbstractGrid<LicenseLogModel> {

    private LicenseLogProperties properties;

    @Override
    protected void handleRpc(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<LicenseLogModel>> callback) {
        LogServiceAsync logService = LogService.ServiceLoader.getInstance();
        logService.listLicenseLogs(loadConfig, callback);
    }

    @Override
    protected List<ColumnConfig<LicenseLogModel, ?>> getColumnConfigs() {
        List<ColumnConfig<LicenseLogModel, ?>> result = new ArrayList<>();
        int size = 200;

        result.add(createColumnConfig(properties.id(), 50, StringConstants.LicenseEventsGrid.ID));
        result.add(createColumnConfig(properties.dt(), 100, StringConstants.LicenseEventsGrid.TIME));
        result.add(createColumnConfig(properties.cryptonumber(), 80, StringConstants.LicenseEventsGrid.CRYPTO_NUMBER));
        result.add(createColumnConfig(properties.method(), size, StringConstants.LicenseEventsGrid.METHOD));
        result.add(createColumnConfig(properties.event(), 90, StringConstants.LicenseEventsGrid.EVENT));
        result.add(createColumnConfig(properties.server(), 120, StringConstants.LicenseEventsGrid.SERVER));
        result.add(createColumnConfig(properties.text(), 300, StringConstants.LicenseEventsGrid.DESCRIPTION));

        return result;
    }

    @Override
    protected ModelKeyProvider<LicenseLogModel> getModelKeyProvider() {
        properties = GWT.create(LicenseLogProperties.class);
        return properties.key();
    }
}
