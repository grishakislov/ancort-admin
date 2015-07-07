package com.mttch.admin.client.server.administrator;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mttch.admin.common.model.grid.AdministratorModel;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

public interface AdministratorServiceAsync {

    void listAdministrators(PagingLoadConfig config, AsyncCallback<PagingLoadResult<AdministratorModel>> async);
    void deleteAdministrator(String name, AsyncCallback<Void> async);

    void addAdministrator(String name, String password, AsyncCallback<Void> async);
}
