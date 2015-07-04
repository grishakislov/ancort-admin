package com.mttch.admin.client.server.init;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.mttch.admin.client.server.login.LoginServiceAsync;
import com.mttch.admin.common.model.InitData;
import org.eclipse.jetty.security.LoginService;

public interface InitServiceAsync {
    void init(AsyncCallback<InitData> async);
}
