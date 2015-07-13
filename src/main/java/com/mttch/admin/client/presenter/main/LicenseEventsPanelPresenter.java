package com.mttch.admin.client.presenter.main;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Inject;
import com.mttch.admin.client.events.LeftMenuToggledEvent;
import com.mttch.admin.client.presenter.AbstractPresenter;
import com.mttch.admin.client.ui.main.center.logs.LicenseEventsGrid;
import com.mttch.admin.client.ui.main.center.logs.LicenseEventsPanel;

public class LicenseEventsPanelPresenter extends AbstractPresenter {

    private LicenseEventsPanel panel;
    private LicenseEventsGrid grid;

    @Inject
    public LicenseEventsPanelPresenter(SimpleEventBus eventBus, LicenseEventsPanel panel) {
        super(eventBus);
        this.panel = panel;
        this.grid = panel.getGrid();
        bind();
    }

    @Override
    public void bind() {
        eventBus.addHandler(LeftMenuToggledEvent.TYPE, new LeftMenuToggledEvent.Handler() {
            @Override
            public void onMenuTypeChanged(LeftMenuToggledEvent.MenuType menuType) {
                if (menuType != LeftMenuToggledEvent.MenuType.EVENTS) {
                    return;
                }
                grid.refresh();
            }
        });

    }
}