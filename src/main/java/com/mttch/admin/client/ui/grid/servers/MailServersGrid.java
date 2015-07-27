package com.mttch.admin.client.ui.grid.servers;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mttch.admin.client.server.servers.ServersService;
import com.mttch.admin.client.server.servers.ServersServiceAsync;
import com.mttch.admin.client.ui.grid.AbstractGrid;
import com.mttch.admin.client.ui.grid.GridSettings;
import com.mttch.admin.common.StringConstants;
import com.mttch.admin.common.model.grid.servers.MailServerModel;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;

import java.util.ArrayList;
import java.util.List;

public class MailServersGrid extends AbstractGrid<MailServerModel> {

    private MailServersProperties mailServersProperties;

    @Override
    protected void handleRpc(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<MailServerModel>> callback) {
        ServersServiceAsync service = ServersService.ServiceLoader.getInstance();
        service.listMailServers(loadConfig, callback);
    }

    @Override
    protected List<ColumnConfig<MailServerModel, ?>> getColumnConfigs() {
        List<ColumnConfig<MailServerModel, ?>> result = new ArrayList<>();

        int size = 150;

        result.add(createColumnConfig(mailServersProperties.hostName(), size, StringConstants.MailServersGrid.HOSTNAME));
        result.add(createColumnConfig(mailServersProperties.popPort(), size, StringConstants.MailServersGrid.POP_PORT));
        result.add(createColumnConfig(mailServersProperties.popSecurity(), size, StringConstants.MailServersGrid.POP_SECURITY));
        result.add(createColumnConfig(mailServersProperties.smtpPort(), size, StringConstants.MailServersGrid.SMTP_PORT));
        result.add(createColumnConfig(mailServersProperties.smtpSecurity(), size, StringConstants.MailServersGrid.SMTP_SECURITY));
        result.add(createColumnConfig(mailServersProperties.ip(), size, StringConstants.MailServersGrid.IP));
        result.add(createColumnConfig(mailServersProperties.baseDir(), size, StringConstants.MailServersGrid.BASE_DIR));
        result.add(createColumnConfig(mailServersProperties.storageNode(), size, StringConstants.MailServersGrid.STORAGE_NODE));
        result.add(createColumnConfig(mailServersProperties.maxMailboxes(), size, StringConstants.MailServersGrid.MAX_MAILBOXES));

        return result;
    }

    @Override
    protected ModelKeyProvider<MailServerModel> getModelKeyProvider() {
        mailServersProperties = GWT.create(MailServersProperties.class);
        return mailServersProperties.key();
    }

    @Override
    protected GridSettings getGridSettings() {
        return new GridSettings(false, false);
    }
}
