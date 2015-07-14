package com.mttch.admin.client;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import com.mttch.admin.client.controller.InitController;
import com.mttch.admin.client.controller.UiController;
import com.mttch.admin.client.presenter.login.LoginPresenter;
import com.mttch.admin.client.presenter.main.*;
import com.mttch.admin.client.ui.login.LoginView;
import com.mttch.admin.client.ui.main.MainPanel;
import com.mttch.admin.client.ui.main.WebAppRootPanel;
import com.mttch.admin.client.ui.main.center.administrators.AddAdministratorDialog;
import com.mttch.admin.client.ui.main.center.administrators.AdministratorsGrid;
import com.mttch.admin.client.ui.main.center.administrators.AdministratorsPanel;
import com.mttch.admin.client.ui.main.center.logs.AdminLogGrid;
import com.mttch.admin.client.ui.main.center.logs.AdminLogPanel;
import com.mttch.admin.client.ui.main.center.logs.LicenseEventsGrid;
import com.mttch.admin.client.ui.main.center.logs.LicenseEventsPanel;
import com.mttch.admin.client.ui.main.center.users.UsersGrid;
import com.mttch.admin.client.ui.main.center.users.UsersPanel;
import com.mttch.admin.client.ui.main.menu.LeftMenu;
import com.mttch.admin.client.ui.main.top.LogoutPanel;
import com.mttch.admin.client.ui.main.top.TopPanel;

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
        bind(LogoutPanel.class).in(Singleton.class);
        bind(TopPanel.class).in(Singleton.class);
        bind(LeftMenu.class).in(Singleton.class);
        bind(MainPanel.class).in(Singleton.class);
        bind(UsersPanel.class).in(Singleton.class);
        bind(UsersGrid.class).in(Singleton.class);

        bind(AdministratorsPanel.class).in(Singleton.class);
        bind(AdministratorsGrid.class).in(Singleton.class);
        bind(AddAdministratorDialog.class).in(Singleton.class);

        bind(LicenseEventsGrid.class).in(Singleton.class);
        bind(LicenseEventsPanel.class).in(Singleton.class);

        bind(AdminLogGrid.class).in(Singleton.class);
        bind(AdminLogPanel.class).in(Singleton.class);

        bind(WebAppRootPanel.class).in(Singleton.class);
    }

    private void bindPresenters() {
        bindEagerSingleton(InitController.class);
        bindEagerSingleton(UiController.class);
        bindEagerSingleton(LoginPresenter.class);
        bindEagerSingleton(LeftMenuPresenter.class);
        bindEagerSingleton(MainPanelPresenter.class);
        bindEagerSingleton(TopPanelPresenter.class);
        bindEagerSingleton(UsersPanelPresenter.class);
        bindEagerSingleton(LicenseEventsPanelPresenter.class);
        bindEagerSingleton(AdminLogPanelPresenter.class);
        bindEagerSingleton(AdministratorsPanelPresenter.class);
    }

    private void bindSingleton(Class cls) {
        bind(cls).in(Singleton.class);
    }

    private void bindEagerSingleton(Class cls) {
        bind(cls).asEagerSingleton();
    }

}
