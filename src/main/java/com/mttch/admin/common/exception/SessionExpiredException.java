package com.mttch.admin.common.exception;

import com.google.gwt.user.client.rpc.IsSerializable;

public class SessionExpiredException extends RuntimeException implements IsSerializable {

    private static final long serialVersionUID = 8318317466559692519L;

    public SessionExpiredException() {
    }
}
