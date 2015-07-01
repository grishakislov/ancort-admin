package com.mttch.admin.client.callback;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;

public abstract class ServerCallback<T> implements AsyncCallback<T> {

    @Override
    public void onFailure(Throwable caught) {
        AlertMessageBox messageBox = new AlertMessageBox("Server Error", caught.getMessage());
        messageBox.show();
    }

    @Override
    public abstract void onSuccess(T result);
}
