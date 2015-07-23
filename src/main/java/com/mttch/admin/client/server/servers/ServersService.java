package com.mttch.admin.client.server.servers;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mttch.admin.common.exception.BusinessException;
import com.mttch.admin.common.model.grid.servers.JabberServerModel;
import com.mttch.admin.common.model.grid.servers.MailServerModel;
import com.mttch.admin.common.model.grid.servers.SipServerModel;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

@RemoteServiceRelativePath("rpc/serversService")
public interface ServersService extends RemoteService {

    PagingLoadResult<SipServerModel> listSipServers(PagingLoadConfig config) throws BusinessException;
    PagingLoadResult<MailServerModel> listMailServers(PagingLoadConfig config) throws BusinessException;
    PagingLoadResult<JabberServerModel> listJabberServers(PagingLoadConfig config) throws BusinessException;

    class ServiceLoader {
        private static ServersServiceAsync instance = null;

        public static synchronized ServersServiceAsync getInstance() {
            if (instance == null) {
                instance = GWT.create(ServersService.class);
            }
            return instance;
        }
    }


}
