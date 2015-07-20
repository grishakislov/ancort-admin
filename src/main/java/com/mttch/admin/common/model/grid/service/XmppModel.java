package com.mttch.admin.common.model.grid.service;

import com.mttch.admin.common.model.grid.BaseGridModel;

public class XmppModel extends BaseGridModel {

    private static final long serialVersionUID = 5828432709190949547L;

    private String username;
    private String name;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
