package com.mttch.admin.client.server.user;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mttch.admin.common.model.grid.UserModel;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

public interface UserServiceAsync {
    void listUsers(PagingLoadConfig config, AsyncCallback<PagingLoadResult<UserModel>> callback);
    void deleteUser(String login, AsyncCallback<Void> async);
}
