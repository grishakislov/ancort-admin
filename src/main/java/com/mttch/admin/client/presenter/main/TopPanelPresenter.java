package com.mttch.admin.client.presenter.main;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Inject;
import com.mttch.admin.client.AppContext;
import com.mttch.admin.client.callback.ServerCallback;
import com.mttch.admin.client.events.LogoutEvent;
import com.mttch.admin.client.events.SetUserEvent;
import com.mttch.admin.client.presenter.AbstractPresenter;
import com.mttch.admin.client.server.login.LoginService;
import com.mttch.admin.client.server.login.LoginServiceAsync;
import com.mttch.admin.client.ui.main.top.TopPanel;
import com.mttch.admin.common.model.CorpUser;
import com.sencha.gxt.widget.core.client.event.SelectEvent;

public class TopPanelPresenter extends AbstractPresenter {

    private TopPanel topPanel;

    @Inject
    public TopPanelPresenter(SimpleEventBus eventBus, TopPanel topPanel) {
        super(eventBus);
        this.topPanel = topPanel;
        bind();
    }

    @Override
    public void bind() {
        topPanel.getUserPanel().getLogoutButton().addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                handleLogout();
            }
        });
        eventBus.addHandler(SetUserEvent.TYPE, new SetUserEvent.Handler() {
            @Override
            public void onUserSet(CorpUser corpUser) {
                topPanel.getUserPanel().setUserName(corpUser.getLogin());
            }
        });
    }

    private void handleLogout() {
        LoginServiceAsync loginService = LoginService.ServiceLoader.getInstance();
        loginService.logout(AppContext.getUser().getLogin(), new ServerCallback<Void>() {
            @Override
            public void onSuccess(Void result) {
                AppContext.logout();
                eventBus.fireEvent(new LogoutEvent());
            }
        });
    }
}
