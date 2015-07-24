package com.mttch.admin.client.presenter.main;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Inject;
import com.mttch.admin.client.events.LeftMenuToggledEvent;
import com.mttch.admin.client.presenter.AbstractPresenter;
import com.mttch.admin.client.ui.grid.logs.AdminLogGrid;
import com.mttch.admin.client.ui.grid.logs.AdminLogPanel;

public class AdminLogPanelPresenter extends AbstractPresenter {

    private AdminLogPanel panel;
    private AdminLogGrid grid;

    @Inject
    public AdminLogPanelPresenter(SimpleEventBus eventBus, AdminLogPanel panel, AdminLogGrid grid) {
        super(eventBus);
        this.panel = panel;
        this.grid = grid;
        bind();
    }

    @Override
    public void bind() {
        eventBus.addHandler(LeftMenuToggledEvent.TYPE, new LeftMenuToggledEvent.Handler() {
            @Override
            public void onMenuTypeChanged(LeftMenuToggledEvent.MenuType menuType) {
                if (menuType != LeftMenuToggledEvent.MenuType.ACTIONS) {
                    return;
                }
                grid.refresh();
            }
        });
    }
}
