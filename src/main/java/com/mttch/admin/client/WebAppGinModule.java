package com.mttch.admin.client;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import com.mttch.admin.client.presenter.UiPresenter;
import com.mttch.admin.client.presenter.login.LoginPresenter;
import com.mttch.admin.client.presenter.main.LeftMenuPresenter;
import com.mttch.admin.client.presenter.main.MainPanelPresenter;
import com.mttch.admin.client.presenter.main.TopPanelPresenter;
import com.mttch.admin.client.presenter.main.UsersPanelPresenter;
import com.mttch.admin.client.ui.login.LoginView;
import com.mttch.admin.client.ui.main.MainPanel;
import com.mttch.admin.client.ui.main.WebAppRootPanel;
import com.mttch.admin.client.ui.main.center.users.UsersGrid;
import com.mttch.admin.client.ui.main.menu.LeftMenu;
import com.mttch.admin.client.ui.main.top.TopPanel;
import com.mttch.admin.client.ui.main.top.UserPanel;

public class WebAppGinModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(SimpleEventBus.class).in(Singleton.class);

        bindView();
        bindPresenters();
    }

    private void bindView() {
        bind(LoginView.class).in(Singleton.class);

        //Main panel
        bind(UserPanel.class).in(Singleton.class);
        bind(TopPanel.class).in(Singleton.class);
        bind(LeftMenu.class).in(Singleton.class);
        bind(MainPanel.class).in(Singleton.class);
        bind(UserPanel.class).in(Singleton.class);
        bind(UsersGrid.class).in(Singleton.class);

        bind(WebAppRootPanel.class).in(Singleton.class);
    }

    private void bindPresenters() {
        bindEagerSingleton(LoginPresenter.class);
        bindEagerSingleton(LeftMenuPresenter.class);
        bindEagerSingleton(UiPresenter.class);
        bindEagerSingleton(MainPanelPresenter.class);
        bindEagerSingleton(TopPanelPresenter.class);
        bindEagerSingleton(UsersPanelPresenter.class);
    }

    private void bindSingleton(Class cls) {
        bind(cls).in(Singleton.class);
    }

    private void bindEagerSingleton(Class cls) {
        bind(cls).asEagerSingleton();
    }

}
