package com.mttch.admin.client.server.log;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mttch.admin.common.exception.BusinessException;
import com.mttch.admin.common.model.grid.log.AdminLogModel;
import com.mttch.admin.common.model.grid.log.LicenseLogModel;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

@RemoteServiceRelativePath("rpc/logService")
public interface LogService extends RemoteService {

    PagingLoadResult<AdminLogModel> listAdminLogs(PagingLoadConfig config) throws BusinessException;

    PagingLoadResult<LicenseLogModel> listLicenseLogs(PagingLoadConfig config) throws BusinessException;

    class ServiceLoader {
        private static LogServiceAsync instance = null;

        public static synchronized LogServiceAsync getInstance() {
            if (instance == null) {
                instance = GWT.create(LogService.class);
            }
            return instance;
        }
    }

}
