package com.mttch.admin.client.presenter.main;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Inject;
import com.mttch.admin.client.events.LeftMenuToggledEvent;
import com.mttch.admin.client.presenter.AbstractPresenter;
import com.mttch.admin.client.ui.grid.servers.ServersPanel;

public class ServersPanelPresenter extends AbstractPresenter {

    private ServersPanel serversPanel;

    @Inject
    public ServersPanelPresenter(SimpleEventBus eventBus, ServersPanel serversPanel) {
        super(eventBus);
        this.serversPanel = serversPanel;
        bind();
    }

    @Override
    public void bind() {
        eventBus.addHandler(LeftMenuToggledEvent.TYPE, new LeftMenuToggledEvent.Handler() {
            @Override
            public void onMenuTypeChanged(LeftMenuToggledEvent.MenuType menuType) {
                if (menuType != LeftMenuToggledEvent.MenuType.SERVERS) {
                    return;
                }
                serversPanel.refreshAll();
            }
        });

    }
}
