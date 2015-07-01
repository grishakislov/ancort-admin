package com.mttch.admin.client.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.mttch.admin.common.model.CorpUser;

public class SetUserEvent extends GwtEvent<SetUserEvent.Handler> {

    public static Type<Handler> TYPE = new Type<Handler>();

    private CorpUser corpUser;

    public SetUserEvent(CorpUser corpUser) {
        this.corpUser = corpUser;
    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(Handler handler) {
        handler.onUserSet(corpUser);
    }

    public static Type<Handler> getTYPE() {
        return TYPE;
    }

    public interface Handler extends EventHandler {
        void onUserSet(CorpUser corpUser);
    }

}
