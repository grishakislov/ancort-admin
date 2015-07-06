package com.mttch.admin.client.server.user;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mttch.admin.common.model.grid.UserModel;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;


@RemoteServiceRelativePath("rpc/userService")

public interface UserService extends RemoteService {
    PagingLoadResult<UserModel> listUsers(PagingLoadConfig config);

    class ServiceLoader {
        private static UserServiceAsync instance = null;

        public static synchronized UserServiceAsync getInstance() {
            if (instance == null) {
                instance = GWT.create(UserService.class);
            }
            return instance;
        }
    }
}
