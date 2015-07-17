package com.mttch.admin.client.callback;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mttch.admin.client.AppContext;
import com.mttch.admin.client.utils.UiFactory;
import com.mttch.admin.common.exception.SessionExpiredException;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;

public abstract class ServerCallback<T> implements AsyncCallback<T> {

    @Override
    public void onFailure(Throwable caught) {
        if (caught.getCause() instanceof SessionExpiredException) {
            AppContext.doLogout();
            UiFactory.showInfo("Error", "Session expired, please log in");
        } else {
            AlertMessageBox messageBox = new AlertMessageBox("Server Error", caught.getMessage());
            messageBox.show();
        }
    }

    @Override
    public abstract void onSuccess(T result);
}
