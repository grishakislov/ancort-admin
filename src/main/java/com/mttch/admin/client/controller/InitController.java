package com.mttch.admin.client.controller;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Cookies;
import com.google.inject.Inject;
import com.mttch.admin.client.AppContext;
import com.mttch.admin.client.callback.ServerCallback;
import com.mttch.admin.client.events.AuthenticationCompletedEvent;
import com.mttch.admin.client.events.LoginNeededEvent;
import com.mttch.admin.client.events.LoginSucceededEvent;
import com.mttch.admin.client.events.SetUserEvent;
import com.mttch.admin.client.server.init.InitService;
import com.mttch.admin.client.server.login.LoginService;
import com.mttch.admin.client.server.login.LoginServiceAsync;
import com.mttch.admin.common.model.AuthenticationResult;
import com.mttch.admin.common.model.InitData;

public class InitController {

    private SimpleEventBus eventBus;

    private LoginServiceAsync loginService;

    @Inject
    public InitController(SimpleEventBus eventBus) {
        this.eventBus = eventBus;
        loginService = LoginService.ServiceLoader.getInstance();
        eventBus.addHandler(AuthenticationCompletedEvent.TYPE, new AuthenticationCompletedEvent.Handler() {
            @Override
            public void onAuthenticationCompleted(AuthenticationResult authenticationResult) {
                handleAuthenticationCompleted(authenticationResult);
            }
        });
    }

    public void go() {
        String cookie = Cookies.getCookie("sessionId");
        if (cookie == null || cookie.equals("null")) {
            handleNullSessionCookie();
        } else {
            handleSessionCookie(cookie);
        }
    }

    private void handleSessionCookie(String cookie) {
        loginService.authenticate(cookie, new ServerCallback<AuthenticationResult>() {
            @Override
            public void onSuccess(AuthenticationResult result) {
                if (result.isAuthenticated()) {
                    handleAuthenticationCompleted(result);
                } else {
                    handleCookieAuthenticationFailed();
                }
            }
        });
    }

    private void handleNullSessionCookie() {
        loginService.autoAuthenticate(new ServerCallback<AuthenticationResult>() {
            @Override
            public void onSuccess(AuthenticationResult result) {
                if (result.isAuthenticated()) {
                    handleAuthenticationCompleted(result);
                } else {
                    handleCookieAuthenticationFailed();
                }
            }
        });
    }

    private void handleAuthenticationCompleted(final AuthenticationResult result) {
        InitService.ServiceLoader.getInstance().init(new ServerCallback<InitData>() {
            @Override
            public void onSuccess(InitData initData) {
                Cookies.setCookie("sessionId", result.getSessionId());
                AppContext.setAuthenticationResult(result);
                AppContext.setInitData(initData);
                eventBus.fireEvent(new SetUserEvent(result.getCorpUser()));
                eventBus.fireEvent(new LoginSucceededEvent());
            }
        });
    }

    private void handleCookieAuthenticationFailed() {
        eventBus.fireEvent(new LoginNeededEvent());
    }
}
