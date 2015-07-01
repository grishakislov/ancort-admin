package com.mttch.admin.client;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.mttch.admin.client.presenter.login.LoginPresenter;
import com.mttch.admin.client.presenter.UiPresenter;
import com.mttch.admin.client.ui.login.LoginView;
import com.mttch.admin.client.ui.main.MainPanel;
import com.mttch.admin.client.ui.main.WebAppRootPanel;

@GinModules(WebAppGinModule.class)
public interface WebAppInjector extends Ginjector {

    public SimpleEventBus getEventBus();


    public MainPanel getMainPanel();

    public LoginView getLoginView();

    public WebAppRootPanel getRootPanel();

    public UiPresenter getUiPresenter();

    public LoginPresenter getLoginPresenter();
}
