package com.mttch.admin.client.ui.main.center.servers;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mttch.admin.client.server.servers.ServersService;
import com.mttch.admin.client.server.servers.ServersServiceAsync;
import com.mttch.admin.client.ui.grid.AbstractGrid;
import com.mttch.admin.client.ui.grid.GridProperties;
import com.mttch.admin.common.StringConstants;
import com.mttch.admin.common.model.grid.servers.SipServerModel;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;

import java.util.ArrayList;
import java.util.List;

public class SipServersGrid extends AbstractGrid<SipServerModel> {

    private SipServersProperties sipServersProperties;

    @Override
    protected void handleRpc(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<SipServerModel>> callback) {
        ServersServiceAsync service = ServersService.ServiceLoader.getInstance();
        service.listSipServers(loadConfig, callback);
    }

    @Override
    protected List<ColumnConfig<SipServerModel, ?>> getColumnConfigs() {
        List<ColumnConfig<SipServerModel, ?>> result = new ArrayList<>();

        int size = 300;

        result.add(createColumnConfig(sipServersProperties.server(), size, StringConstants.SipServersGrid.SERVER));
        result.add(createColumnConfig(sipServersProperties.description(), size, StringConstants.SipServersGrid.DESCRIPTION));
        result.add(createColumnConfig(sipServersProperties.active(), size, StringConstants.SipServersGrid.ACTIVE));

        return result;
    }

    @Override
    protected ModelKeyProvider<SipServerModel> getModelKeyProvider() {
        sipServersProperties = GWT.create(SipServersProperties.class);
        return sipServersProperties.key();
    }

    @Override
    protected GridProperties getGridProperties() {
        return new GridProperties(false, false);
    }
}
