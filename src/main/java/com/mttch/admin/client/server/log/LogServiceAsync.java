package com.mttch.admin.client.server.log;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mttch.admin.common.model.grid.log.AdminLogModel;
import com.mttch.admin.common.model.grid.log.LicenseLogModel;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

public interface LogServiceAsync {
    void listAdminLogs(PagingLoadConfig config, AsyncCallback<PagingLoadResult<AdminLogModel>> async);

    void listLicenseLogs(PagingLoadConfig config, AsyncCallback<PagingLoadResult<LicenseLogModel>> async);
}
