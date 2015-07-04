package com.mttch.admin.client.controller;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Inject;
import com.mttch.admin.client.AppContext;
import com.mttch.admin.client.events.LoginSucceededEvent;
import com.mttch.admin.client.events.LogoutEvent;
import com.mttch.admin.client.events.LoginNeededEvent;
import com.mttch.admin.client.presenter.AbstractPresenter;
import com.mttch.admin.client.ui.login.LoginView;
import com.mttch.admin.client.ui.main.MainPanel;
import com.mttch.admin.client.ui.main.WebAppRootPanel;
import com.mttch.admin.common.model.InitData;
import com.sencha.gxt.widget.core.client.ContentPanel;

public class UiController extends AbstractPresenter {

    private WebAppRootPanel rootPanel;
    private LoginView loginView;
    private MainPanel mainPanel;

    @Inject
    public UiController(SimpleEventBus eventBus, WebAppRootPanel rootPanel, LoginView loginView, MainPanel mainPanel) {
        super(eventBus);
        this.eventBus = eventBus;
        this.rootPanel = rootPanel;
        this.loginView = loginView;
        this.mainPanel = mainPanel;
        bind();
    }

    @Override
    public void bind() {
        eventBus.addHandler(LoginNeededEvent.TYPE, new LoginNeededEvent.Handler() {
            @Override
            public void onLoginNeeded() {
                setScreen(loginView);
            }
        });

        eventBus.addHandler(LoginSucceededEvent.TYPE, new LoginSucceededEvent.Handler() {
            @Override
            public void onLogin() {
                setScreen(mainPanel);
            }
        });

        eventBus.addHandler(LogoutEvent.TYPE, new LogoutEvent.Handler() {
            @Override
            public void onLogout() {
                setScreen(loginView);
            }
        });

    }

    private void setScreen(ContentPanel screen) {
        rootPanel.clear();
        rootPanel.add(screen);
        rootPanel.forceLayout();
    }

}
