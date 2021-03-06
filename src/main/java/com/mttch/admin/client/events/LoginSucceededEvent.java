package com.mttch.admin.client.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class LoginSucceededEvent extends GwtEvent<LoginSucceededEvent.Handler> {

    public static Type<Handler> TYPE = new Type<>();

    public LoginSucceededEvent() {
    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(Handler handler) {
        handler.onLogin();
    }

    public static Type<Handler> getTYPE() {
        return TYPE;
    }

    public interface Handler extends EventHandler {
        void onLogin();
    }
}
