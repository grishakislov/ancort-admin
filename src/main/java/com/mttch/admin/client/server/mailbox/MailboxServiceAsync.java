package com.mttch.admin.client.server.mailbox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mttch.admin.client.server.log.LogServiceAsync;
import com.mttch.admin.common.model.grid.log.LicenseLogModel;
import com.mttch.admin.common.model.grid.service.MailboxModel;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

public interface MailboxServiceAsync {
    void listMailboxes(PagingLoadConfig config, AsyncCallback<PagingLoadResult<MailboxModel>> async);
}
