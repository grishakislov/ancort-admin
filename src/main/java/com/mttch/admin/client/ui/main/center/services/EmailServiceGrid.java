package com.mttch.admin.client.ui.main.center.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mttch.admin.client.server.mailbox.MailboxService;
import com.mttch.admin.client.server.mailbox.MailboxServiceAsync;
import com.mttch.admin.client.ui.AbstractGrid;
import com.mttch.admin.common.StringConstants;
import com.mttch.admin.common.model.grid.service.MailboxModel;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;

import java.util.ArrayList;
import java.util.List;

public class EmailServiceGrid extends AbstractGrid<MailboxModel> {

    private MailboxProperties mailboxProperties;

    @Override
    protected void handleRpc(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<MailboxModel>> callback) {
        MailboxServiceAsync service = MailboxService.ServiceLoader.getInstance();
        service.listMailboxes(loadConfig, callback);
    }

    @Override
    protected List<ColumnConfig<MailboxModel, ?>> getColumnConfigs() {
        List<ColumnConfig<MailboxModel, ?>> result = new ArrayList<>();
        int size = 200;

        result.add(createColumnConfig(mailboxProperties.login(), 80, StringConstants.EmailServiceGrid.LOGIN));
        result.add(createColumnConfig(mailboxProperties.username(), size, StringConstants.EmailServiceGrid.MAILBOX));
        result.add(createColumnConfig(mailboxProperties.password(), 80, StringConstants.EmailServiceGrid.PASSWORD));
        result.add(createColumnConfig(mailboxProperties.quota(), 70, StringConstants.EmailServiceGrid.QUOTA));
        result.add(createColumnConfig(mailboxProperties.maildir(), 300, StringConstants.EmailServiceGrid.STORAGE));

        return result;
    }

    @Override
    protected ModelKeyProvider<MailboxModel> getModelKeyProvider() {
        mailboxProperties = GWT.create(MailboxProperties.class);
        return mailboxProperties.key();
    }
}
