package com.mttch.admin.client.server.login;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mttch.admin.common.model.AuthenticationResult;

public interface LoginServiceAsync {
    void authenticate(String login, String password, AsyncCallback<AuthenticationResult> async);
    void logout(String login, AsyncCallback<Void> async);
}
