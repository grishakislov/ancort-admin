package com.mttch.admin.client.ui.grid.logs;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mttch.admin.client.server.log.LogService;
import com.mttch.admin.client.server.log.LogServiceAsync;
import com.mttch.admin.client.ui.grid.AbstractGrid;
import com.mttch.admin.common.StringConstants;
import com.mttch.admin.common.model.grid.log.AdminLogModel;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;

import java.util.ArrayList;
import java.util.List;

public class AdminLogGrid extends AbstractGrid<AdminLogModel> {

    private AdminLogProperties adminLogProperties;

    @Override
    protected void handleRpc(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<AdminLogModel>> callback) {
        LogServiceAsync logService = LogService.ServiceLoader.getInstance();
        logService.listAdminLogs(loadConfig, callback);
    }

    @Override
    protected List<ColumnConfig<AdminLogModel, ?>> getColumnConfigs() {
        List<ColumnConfig<AdminLogModel, ?>> result = new ArrayList<>();

        int size = 180;

        result.add(createColumnConfig(adminLogProperties.id(), 50, StringConstants.AdminLogGrid.ID));
        result.add(createColumnConfig(adminLogProperties.cryptonumber(), 80, StringConstants.AdminLogGrid.CRYPTO_NUMBER));
        result.add(createColumnConfig(adminLogProperties.dt(), 100, StringConstants.AdminLogGrid.DATE_TIME));
        result.add(createColumnConfig(adminLogProperties.user(), 90, StringConstants.AdminLogGrid.ADMIN));
        result.add(createColumnConfig(adminLogProperties.useragent(), 430, StringConstants.AdminLogGrid.USER_AGENT));
        result.add(createColumnConfig(adminLogProperties.text(), 70, StringConstants.AdminLogGrid.EVENT));
        result.add(createColumnConfig(adminLogProperties.ip(), 90, StringConstants.AdminLogGrid.IP));

        return result;
    }

    @Override
    protected ModelKeyProvider<AdminLogModel> getModelKeyProvider() {
        adminLogProperties = GWT.create(AdminLogProperties.class);
        return adminLogProperties.key();
    }
}
