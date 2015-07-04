package com.mttch.admin.client.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.mttch.admin.common.model.AuthenticationResult;

public class AuthenticationCompletedEvent extends GwtEvent<AuthenticationCompletedEvent.Handler> {

    public static GwtEvent.Type<Handler> TYPE = new GwtEvent.Type<Handler>();

    private AuthenticationResult authenticationResult;

    public AuthenticationCompletedEvent(AuthenticationResult authenticationResult) {
        this.authenticationResult = authenticationResult;
    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(Handler handler) {
        handler.onAuthenticationCompleted(authenticationResult);
    }

    public static GwtEvent.Type<Handler> getTYPE() {
        return TYPE;
    }

    public interface Handler extends EventHandler {
        void onAuthenticationCompleted(AuthenticationResult authenticationResult);
    }


}
