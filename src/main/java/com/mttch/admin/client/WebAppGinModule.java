package com.mttch.admin.client;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import com.mttch.admin.client.controller.InitController;
import com.mttch.admin.client.controller.UiController;
import com.mttch.admin.client.presenter.login.LoginPresenter;
import com.mttch.admin.client.presenter.main.*;
import com.mttch.admin.client.ui.grid.administrators.AddAdministratorDialog;
import com.mttch.admin.client.ui.grid.administrators.AdministratorsGrid;
import com.mttch.admin.client.ui.grid.administrators.AdministratorsPanel;
import com.mttch.admin.client.ui.grid.logs.AdminLogGrid;
import com.mttch.admin.client.ui.grid.logs.AdminLogPanel;
import com.mttch.admin.client.ui.grid.logs.LicenseEventsGrid;
import com.mttch.admin.client.ui.grid.logs.LicenseEventsPanel;
import com.mttch.admin.client.ui.grid.servers.JabberServersGrid;
import com.mttch.admin.client.ui.grid.servers.MailServersGrid;
import com.mttch.admin.client.ui.grid.servers.ServersPanel;
import com.mttch.admin.client.ui.grid.servers.SipServersGrid;
import com.mttch.admin.client.ui.grid.services.EmailServiceGrid;
import com.mttch.admin.client.ui.grid.services.EmailServicePanel;
import com.mttch.admin.client.ui.grid.services.XmppServiceGrid;
import com.mttch.admin.client.ui.grid.services.XmppServicePanel;
import com.mttch.admin.client.ui.grid.users.UsersGrid;
import com.mttch.admin.client.ui.grid.users.UsersPanel;
import com.mttch.admin.client.ui.login.LoginView;
import com.mttch.admin.client.ui.main.MainPanel;
import com.mttch.admin.client.ui.main.WebAppRootPanel;
import com.mttch.admin.client.ui.main.menu.LeftMenu;
import com.mttch.admin.client.ui.main.top.LogoutPanel;
import com.mttch.admin.client.ui.main.top.TopPanel;

public class WebAppGinModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bindSingleton(SimpleEventBus.class);

        bindView();
        bindPresenters();
    }

    private void bindView() {
        bindSingleton(LoginView.class);

        //Main panel
        bindSingleton(LogoutPanel.class);
        bindSingleton(TopPanel.class);
        bindSingleton(LeftMenu.class);
        bindSingleton(MainPanel.class);
        bindSingleton(UsersPanel.class);
        bindSingleton(UsersGrid.class);

        bindSingleton(AdministratorsPanel.class);
        bindSingleton(AdministratorsGrid.class);
        bindSingleton(AddAdministratorDialog.class);

        bindSingleton(LicenseEventsGrid.class);
        bindSingleton(LicenseEventsPanel.class);

        bindSingleton(AdminLogGrid.class);
        bindSingleton(AdminLogPanel.class);

        bindSingleton(EmailServiceGrid.class);
        bindSingleton(EmailServicePanel.class);

        bindSingleton(XmppServiceGrid.class);
        bindSingleton(XmppServicePanel.class);

        bindSingleton(MailServersGrid.class);
        bindSingleton(SipServersGrid.class);
        bindSingleton(JabberServersGrid.class);
        bindSingleton(ServersPanel.class);

        bindSingleton(WebAppRootPanel.class);
    }

    //TODO: refactoring
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
        bindEagerSingleton(EmailServicePresenter.class);
        bindEagerSingleton(XmppPanelPresenter.class);
        bindEagerSingleton(ServersPanelPresenter.class);
    }

    private void bindSingleton(Class cls) {
        bind(cls).in(Singleton.class);
    }

    private void bindEagerSingleton(Class cls) {
        bind(cls).asEagerSingleton();
    }

}
