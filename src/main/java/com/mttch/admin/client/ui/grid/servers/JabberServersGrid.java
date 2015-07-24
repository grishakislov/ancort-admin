package com.mttch.admin.client.ui.grid.servers;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mttch.admin.client.server.servers.ServersService;
import com.mttch.admin.client.server.servers.ServersServiceAsync;
import com.mttch.admin.client.ui.grid.AbstractGrid;
import com.mttch.admin.client.ui.grid.GridProperties;
import com.mttch.admin.common.StringConstants;
import com.mttch.admin.common.model.grid.servers.JabberServerModel;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;

import java.util.ArrayList;
import java.util.List;

public class JabberServersGrid extends AbstractGrid<JabberServerModel> {

    private JabberServersProperties jabberServersProperties;

    @Override
    protected void handleRpc(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<JabberServerModel>> callback) {
        ServersServiceAsync service = ServersService.ServiceLoader.getInstance();
        service.listJabberServers(loadConfig, callback);
    }

    @Override
    protected List<ColumnConfig<JabberServerModel, ?>> getColumnConfigs() {
        List<ColumnConfig<JabberServerModel, ?>> result = new ArrayList<>();

        int size = 300;

        result.add(createColumnConfig(jabberServersProperties.description(), size, StringConstants.JabberServersGrid.DESCRIPTION));
        result.add(createColumnConfig(jabberServersProperties.jabberserver(), size, StringConstants.JabberServersGrid.SERVER));
        result.add(createColumnConfig(jabberServersProperties.jabberserverconf(), size, StringConstants.JabberServersGrid.DNS));
        result.add(createColumnConfig(jabberServersProperties.jabberport(), size, StringConstants.JabberServersGrid.PORT));
        result.add(createColumnConfig(jabberServersProperties.jabberportssl(), size, StringConstants.JabberServersGrid.SSL_PORT));
        result.add(createColumnConfig(jabberServersProperties.act(), size, StringConstants.JabberServersGrid.ACTIVE));

        return result;
    }

    @Override
    protected ModelKeyProvider<JabberServerModel> getModelKeyProvider() {
        jabberServersProperties = GWT.create(JabberServersProperties.class);
        return jabberServersProperties.key();
    }

    @Override
    protected GridProperties getGridProperties() {
        return new GridProperties(false, false);
    }
}
