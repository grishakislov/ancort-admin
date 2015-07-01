package com.mttch.admin.client.server.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mttch.admin.common.model.AuthenticationResult;

@RemoteServiceRelativePath("rpc/loginService")
public interface LoginService extends RemoteService {

    AuthenticationResult authenticate(String login, String password);
    void logout(String login);

    class ServiceLoader {

        private static LoginServiceAsync instance = null;
        public static synchronized LoginServiceAsync getInstance() {
            if (instance == null) {
                instance = GWT.create(LoginService.class);
            }
            return instance;
        }
    }



}
