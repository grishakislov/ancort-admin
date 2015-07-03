package com.mttch.admin.client.server.user;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.mttch.admin.common.model.grid.UserModel;

import java.util.List;

public interface UserServiceAsync {
    void listUsers(int start, int limit, AsyncCallback<List<UserModel>> async);
}
