package com.mttch.admin.client.server.init;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.mttch.admin.common.model.InitData;

public interface InitService extends RemoteService {

    public InitData init();

    class ServiceLoader {
        private static InitServiceAsync instance = null;

        public static synchronized InitServiceAsync getInstance() {
            if (instance == null) {
                instance = GWT.create(InitService.class);
            }
            return instance;
        }
    }

}
