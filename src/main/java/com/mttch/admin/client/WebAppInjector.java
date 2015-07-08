package com.mttch.admin.client;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.mttch.admin.client.controller.InitController;
import com.mttch.admin.client.controller.UiController;
import com.mttch.admin.client.presenter.login.LoginPresenter;
import com.mttch.admin.client.ui.login.LoginView;
import com.mttch.admin.client.ui.main.MainPanel;
import com.mttch.admin.client.ui.main.WebAppRootPanel;
import com.mttch.admin.client.ui.main.center.users.UsersGrid;
import com.mttch.admin.client.ui.main.center.users.UsersPanel;
import com.mttch.admin.client.ui.main.menu.LeftMenu;
import com.mttch.admin.client.ui.main.top.LogoutPanel;
import com.mttch.admin.client.ui.main.top.TopPanel;

@GinModules(WebAppGinModule.class)
public interface WebAppInjector extends Ginjector {

    SimpleEventBus getEventBus();


    MainPanel getMainPanel();

    LoginView getLoginView();

    WebAppRootPanel getRootPanel();

    UiController getUiPresenter();

    LoginPresenter getLoginPresenter();
    LeftMenu getLeftMenu();
    UsersPanel getUsersPanel();
    UsersGrid getUsersGrid();
    TopPanel getTopPanel();

    LogoutPanel getUserPanel();

    InitController getInitController();
}
