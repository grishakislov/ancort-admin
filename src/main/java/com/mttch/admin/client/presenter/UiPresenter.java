package com.mttch.admin.client.presenter;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Inject;
import com.mttch.admin.client.events.LoginSucceededEvent;
import com.mttch.admin.client.events.LogoutEvent;
import com.mttch.admin.client.events.UiInitializationFinishedEvent;
import com.mttch.admin.client.ui.login.LoginView;
import com.mttch.admin.client.ui.main.MainPanel;
import com.mttch.admin.client.ui.main.WebAppRootPanel;
import com.sencha.gxt.widget.core.client.ContentPanel;

public class UiPresenter extends AbstractPresenter {

    private WebAppRootPanel rootPanel;
    private LoginView loginView;
    private MainPanel mainPanel;

    @Inject
    public UiPresenter(SimpleEventBus eventBus,
                       WebAppRootPanel rootPanel,
                       LoginView loginView,
                       MainPanel mainPanel) {
        super(eventBus);
        this.eventBus = eventBus;
        this.rootPanel = rootPanel;
        this.loginView = loginView;
        this.mainPanel = mainPanel;
        bind();
    }

    @Override
    public void bind() {
        eventBus.addHandler(UiInitializationFinishedEvent.TYPE, new UiInitializationFinishedEvent.Handler() {
            @Override
            public void onInit(UiInitializationFinishedEvent event) {
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
