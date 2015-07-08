package com.mttch.admin.client.server.init;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mttch.admin.common.model.InitData;

public interface InitServiceAsync {
    void init(AsyncCallback<InitData> async);
}
