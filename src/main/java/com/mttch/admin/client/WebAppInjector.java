package com.mttch.admin.client;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.mttch.admin.client.controller.InitController;
import com.mttch.admin.client.ui.main.WebAppRootPanel;

@GinModules(WebAppGinModule.class)
public interface WebAppInjector extends Ginjector {

    SimpleEventBus getEventBus();

    WebAppRootPanel getRootPanel();

    InitController getInitController();
}
