package com.mttch.admin.client.server.mailbox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mttch.admin.common.model.grid.service.MailboxModel;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

@RemoteServiceRelativePath("rpc/mailboxService")
public interface MailboxService extends RemoteService {

    PagingLoadResult<MailboxModel> listMailboxes(PagingLoadConfig config);

    class ServiceLoader {
        private static MailboxServiceAsync instance = null;

        public static synchronized MailboxServiceAsync getInstance() {
            if (instance == null) {
                instance = GWT.create(MailboxService.class);
            }
            return instance;
        }
    }
}
