package com.mttch.admin.client.ui.main.center.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mttch.admin.client.server.xmpp.XmppService;
import com.mttch.admin.client.server.xmpp.XmppServiceAsync;
import com.mttch.admin.client.ui.AbstractGrid;
import com.mttch.admin.common.StringConstants;
import com.mttch.admin.common.model.grid.service.XmppModel;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;

import java.util.ArrayList;
import java.util.List;

public class XmppServiceGrid extends AbstractGrid<XmppModel> {

    private XmppProperties properties;

    @Override
    protected void handleRpc(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<XmppModel>> callback) {
        XmppServiceAsync service = XmppService.ServiceLoader.getInstance();
        service.listXmppUsers(loadConfig, callback);
    }

    @Override
    protected List<ColumnConfig<XmppModel, ?>> getColumnConfigs() {
        List<ColumnConfig<XmppModel, ?>> result = new ArrayList<>();
        int size = 200;

        result.add(createColumnConfig(properties.username(), size, StringConstants.XmppGrid.USERNAME));
        result.add(createColumnConfig(properties.name(), size, StringConstants.XmppGrid.NAME));
        result.add(createColumnConfig(properties.email(), size, StringConstants.XmppGrid.EMAIL));

        return result;
    }

    @Override
    protected ModelKeyProvider<XmppModel> getModelKeyProvider() {
        properties = GWT.create(XmppProperties.class);
        return properties.key();
    }
}
