package com.mttch.admin.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.mttch.admin.client.controller.InitController;
import com.mttch.admin.client.ui.main.WebAppRootPanel;
import com.sencha.gxt.widget.core.client.container.Viewport;

public class WebAppEntryPoint implements EntryPoint {

    private final WebAppInjector injector = GWT.create(WebAppInjector.class);

    @Override
    public void onModuleLoad() {
        System.out.println("Module loaded");
        InitController initController = injector.getInitController();

        WebAppRootPanel webAppRootPanel = injector.getRootPanel();

        Viewport viewport = new Viewport();
        viewport.add(webAppRootPanel);

        RootPanel.get().add(viewport);
        initController.go();
    }

}
