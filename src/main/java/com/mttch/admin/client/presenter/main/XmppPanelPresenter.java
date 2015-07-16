package com.mttch.admin.client.presenter.main;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Inject;
import com.mttch.admin.client.events.LeftMenuToggledEvent;
import com.mttch.admin.client.presenter.AbstractPresenter;
import com.mttch.admin.client.ui.main.center.services.XmppServiceGrid;
import com.mttch.admin.client.ui.main.center.services.XmppServicePanel;

public class XmppPanelPresenter extends AbstractPresenter {

    private XmppServicePanel panel;
    private XmppServiceGrid grid;

    @Inject
    public XmppPanelPresenter(SimpleEventBus eventBus, XmppServicePanel panel) {
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
                if (menuType != LeftMenuToggledEvent.MenuType.XMPP) {
                    return;
                }
                grid.refresh();
            }
        });
    }
}
