package com.mttch.admin.client.server.servers;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mttch.admin.common.model.grid.servers.JabberServerModel;
import com.mttch.admin.common.model.grid.servers.MailServerModel;
import com.mttch.admin.common.model.grid.servers.SipServerModel;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

public interface ServersServiceAsync {
    void listSipServers(PagingLoadConfig config, AsyncCallback<PagingLoadResult<SipServerModel>> async);

    void listMailServers(PagingLoadConfig config, AsyncCallback<PagingLoadResult<MailServerModel>> async);

    void listJabberServers(PagingLoadConfig config, AsyncCallback<PagingLoadResult<JabberServerModel>> async);
}
