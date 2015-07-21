package com.mttch.admin.client.server.xmpp;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mttch.admin.common.exception.BusinessException;
import com.mttch.admin.common.model.grid.service.XmppModel;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

@RemoteServiceRelativePath("rpc/xmppService")
public interface XmppService extends RemoteService {

    PagingLoadResult<XmppModel> listXmppUsers(PagingLoadConfig config) throws BusinessException;

    class ServiceLoader {
        private static XmppServiceAsync instance = null;

        public static synchronized XmppServiceAsync getInstance() {
            if (instance == null) {
                instance = GWT.create(XmppService.class);
            }
            return instance;
        }
    }
}
