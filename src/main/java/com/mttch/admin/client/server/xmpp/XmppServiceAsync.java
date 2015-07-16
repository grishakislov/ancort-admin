package com.mttch.admin.client.server.xmpp;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mttch.admin.common.model.grid.service.XmppModel;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

public interface XmppServiceAsync {

    void listXmppUsers(PagingLoadConfig config, AsyncCallback<PagingLoadResult<XmppModel>> async);

}
