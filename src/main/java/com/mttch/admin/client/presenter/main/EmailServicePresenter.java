package com.mttch.admin.client.presenter.main;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Inject;
import com.mttch.admin.client.events.LeftMenuToggledEvent;
import com.mttch.admin.client.presenter.AbstractPresenter;
import com.mttch.admin.client.ui.main.center.services.EmailServiceGrid;
import com.mttch.admin.client.ui.main.center.services.EmailServicePanel;

public class EmailServicePresenter extends AbstractPresenter {

    private EmailServicePanel panel;
    private EmailServiceGrid grid;

    @Inject
    public EmailServicePresenter(SimpleEventBus eventBus, EmailServicePanel panel) {
        super(eventBus);
        this.panel = panel;
        grid = panel.getGrid();
        bind();
    }

    @Override
    public void bind() {
        eventBus.addHandler(LeftMenuToggledEvent.TYPE, new LeftMenuToggledEvent.Handler() {
            @Override
            public void onMenuTypeChanged(LeftMenuToggledEvent.MenuType menuType) {
                if (menuType != LeftMenuToggledEvent.MenuType.EMAIL) {
                    return;
                }
                grid.refresh();
            }
        });

    }
}
