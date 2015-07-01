package com.mttch.admin.client.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class UiInitializationFinishedEvent extends GwtEvent<UiInitializationFinishedEvent.Handler> {

    public static GwtEvent.Type<Handler> TYPE = new GwtEvent.Type<Handler>();

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(Handler handler) {
        handler.onInit(this);
    }

    public static GwtEvent.Type<Handler> getTYPE() {
        return TYPE;
    }

    public interface Handler extends EventHandler {
        void onInit(UiInitializationFinishedEvent event);
    }

}
