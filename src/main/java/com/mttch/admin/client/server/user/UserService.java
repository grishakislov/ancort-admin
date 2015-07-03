package com.mttch.admin.client.server.user;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mttch.admin.common.model.grid.UserModel;

import java.util.List;

@RemoteServiceRelativePath("rpc/userService")

public interface UserService extends RemoteService {
    List<UserModel> listUsers(int start, int limit);

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
