package com.mttch.admin.client.server.administrator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mttch.admin.common.model.grid.AdministratorModel;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

@RemoteServiceRelativePath("rpc/administratorService")
public interface AdministratorService extends RemoteService {
    PagingLoadResult<AdministratorModel> listAdministrators(PagingLoadConfig config);
    void deleteAdministrator(String name);
    void addAdministrator(String name, String password);

    class ServiceLoader {
        private static AdministratorServiceAsync instance = null;

        public static synchronized AdministratorServiceAsync getInstance() {
            if (instance == null) {
                instance = GWT.create(AdministratorService.class);
            }
            return instance;
        }
    }
}
