package com.mttch.admin.client.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class LogoutEvent extends GwtEvent<LogoutEvent.Handler> {

    public static Type<Handler> TYPE = new Type<Handler>();

    public LogoutEvent() {
    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(Handler handler) {
        handler.onLogout();
    }

    public static Type<Handler> getTYPE() {
        return TYPE;
    }

    public interface Handler extends EventHandler {
        void onLogout();
    }

}
