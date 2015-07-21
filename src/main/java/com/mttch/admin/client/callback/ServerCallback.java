package com.mttch.admin.client.callback;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mttch.admin.client.AppContext;
import com.mttch.admin.client.utils.UiFactory;
import com.mttch.admin.common.exception.BusinessException;

public abstract class ServerCallback<T> implements AsyncCallback<T> {

    @Override
    public void onFailure(Throwable caught) {
        if (caught instanceof BusinessException) {
            AppContext.handleBusinessException((BusinessException) caught);
        } else {
            UiFactory.alert("Server Error", caught.getMessage());
        }
    }

    @Override
    public abstract void onSuccess(T result);
}
