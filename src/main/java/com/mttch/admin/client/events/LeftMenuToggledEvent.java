package com.mttch.admin.client.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class LeftMenuToggledEvent extends GwtEvent<LeftMenuToggledEvent.Handler> {

    public static Type<Handler> TYPE = new Type<Handler>();

    public enum MenuType {
        USERS,
        SERVERS,
        ADMINISTRATORS,
        SIP,
        EMAIL,
        XMPP,
        EVENTS,
        ACTIONS;
    }

    private MenuType menuType;

    public LeftMenuToggledEvent(MenuType menuType) {
        this.menuType = menuType;
    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(Handler handler) {
        handler.onMenuTypeChanged(menuType);
    }

    public static Type<Handler> getTYPE() {
        return TYPE;
    }

    public interface Handler extends EventHandler {
        void onMenuTypeChanged(MenuType menuType);
    }
}
