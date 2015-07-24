package com.mttch.admin.client;

import com.google.gwt.event.shared.SimpleEventBus;
import com.mttch.admin.client.events.LogoutEvent;
import com.mttch.admin.client.utils.UiFactory;
import com.mttch.admin.common.exception.BusinessException;
import com.mttch.admin.common.exception.OperationResult;
import com.mttch.admin.common.model.AuthenticationResult;
import com.mttch.admin.common.model.CorpUser;
import com.mttch.admin.common.model.InitData;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent;

public class AppContext {

    private static AuthenticationResult authenticationResult;
    private static InitData initData;
    private static SimpleEventBus eventBus;
    private static volatile boolean exceptionDialogShowed;

    public static void setEventBus(SimpleEventBus eventBus) {
        AppContext.eventBus = eventBus;
    }

    public static CorpUser getUser() {
        return authenticationResult.getCorpUser();
    }

    public static void handleBusinessException(BusinessException e) {

        if (e.getCode() == OperationResult.SESSION_EXPIRED ||
                e.getCode() == OperationResult.NOT_AUTHENTICATED) {
            if (!exceptionDialogShowed) {
                exceptionDialogShowed = true;
                UiFactory.alert("Error", "Session expired, please log in", new DialogHideEvent.DialogHideHandler() {
                    @Override
                    public void onDialogHide(DialogHideEvent event) {
                        exceptionDialogShowed = false;
                        doLogout();
                    }
                });
            }
        } else {
            UiFactory.alert("Error", e.getMessage());
        }
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
