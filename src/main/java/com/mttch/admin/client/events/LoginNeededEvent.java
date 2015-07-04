package com.mttch.admin.client.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.mttch.admin.common.model.InitData;

public class LoginNeededEvent extends GwtEvent<LoginNeededEvent.Handler> {

    public static GwtEvent.Type<Handler> TYPE = new GwtEvent.Type<Handler>();

    public LoginNeededEvent() {
    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(Handler handler) {
        handler.onLoginNeeded();
    }

    public static GwtEvent.Type<Handler> getTYPE() {
        return TYPE;
    }

    public interface Handler extends EventHandler {
        void onLoginNeeded();
    }

}
