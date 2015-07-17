package com.mttch.admin.client;

import com.google.gwt.event.shared.SimpleEventBus;
import com.mttch.admin.client.events.LogoutEvent;
import com.mttch.admin.common.model.AuthenticationResult;
import com.mttch.admin.common.model.CorpUser;
import com.mttch.admin.common.model.InitData;

public class AppContext {

    private static AuthenticationResult authenticationResult;
    private static InitData initData;
    private static SimpleEventBus eventBus;

    public static void setEventBus(SimpleEventBus eventBus) {
        AppContext.eventBus = eventBus;
    }

    public static CorpUser getUser() {
        return authenticationResult.getCorpUser();
    }

    public static void doLogout() {
        onLogout();
        eventBus.fireEvent(new LogoutEvent());
    }

    public static void onLogout() {
        initData = null;
        authenticationResult = null;
    }

    public static void setInitData(InitData value) {
        initData = value;
    }

    public static InitData getInitData() {
        return initData;
    }

    public static AuthenticationResult getAuthenticationResult() {
        return authenticationResult;
    }

    public static void setAuthenticationResult(AuthenticationResult authenticationResult) {
        AppContext.authenticationResult = authenticationResult;
    }
}
