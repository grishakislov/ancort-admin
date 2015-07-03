package com.mttch.admin.client.presenter.main;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Inject;
import com.mttch.admin.client.AppContext;
import com.mttch.admin.client.events.LeftMenuToggledEvent;
import com.mttch.admin.client.events.LoginSucceededEvent;
import com.mttch.admin.client.presenter.AbstractPresenter;
import com.mttch.admin.client.ui.main.menu.LeftMenu;
import com.sencha.gxt.widget.core.client.event.SelectEvent;

public class LeftMenuPresenter extends AbstractPresenter {

    private LeftMenu leftMenu;

    @Inject
    public LeftMenuPresenter(SimpleEventBus eventBus) {
        super(eventBus);
        this.leftMenu = AppContext.injector.getLeftMenu();
        bind();
    }

    @Override
    public void bind() {
        eventBus.addHandler(LoginSucceededEvent.TYPE, new LoginSucceededEvent.Handler() {
            @Override
            public void onLogin() {
                toggleDefaultButton();
            }
        });

        leftMenu.getUsersButton().addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                eventBus.fireEvent(new LeftMenuToggledEvent(LeftMenuToggledEvent.MenuType.USERS));
            }
        });

        leftMenu.getServersButton().addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                eventBus.fireEvent(new LeftMenuToggledEvent(LeftMenuToggledEvent.MenuType.SERVERS));
            }
        });

        leftMenu.getAdministrationButton().addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                eventBus.fireEvent(new LeftMenuToggledEvent(LeftMenuToggledEvent.MenuType.ADMINISTRATION));
            }
        });

        leftMenu.getSipButton().addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                eventBus.fireEvent(new LeftMenuToggledEvent(LeftMenuToggledEvent.MenuType.SIP));
            }
        });

        leftMenu.getEmailButton().addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                eventBus.fireEvent(new LeftMenuToggledEvent(LeftMenuToggledEvent.MenuType.EMAIL));
            }
        });

        leftMenu.getXmppButton().addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                eventBus.fireEvent(new LeftMenuToggledEvent(LeftMenuToggledEvent.MenuType.XMPP));
            }
        });

        leftMenu.getEventsButton().addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                eventBus.fireEvent(new LeftMenuToggledEvent(LeftMenuToggledEvent.MenuType.EVENTS));
            }
        });

        leftMenu.getActionsButton().addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                eventBus.fireEvent(new LeftMenuToggledEvent(LeftMenuToggledEvent.MenuType.ACTIONS));
            }
        });
    }

    private void toggleDefaultButton() {
        leftMenu.getUsersButton().setValue(true);
        eventBus.fireEvent(new LeftMenuToggledEvent(LeftMenuToggledEvent.MenuType.USERS));
    }
}
