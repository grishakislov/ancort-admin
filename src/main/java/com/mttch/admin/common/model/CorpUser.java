package com.mttch.admin.common.model;

import java.io.Serializable;

public class CorpUser implements Serializable {

    private static final long serialVersionUID = 4224562138489171169L;
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
