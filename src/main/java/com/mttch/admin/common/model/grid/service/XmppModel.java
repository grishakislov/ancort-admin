package com.mttch.admin.common.model.grid.service;

import java.io.Serializable;

public class XmppModel implements Serializable {

    private static final long serialVersionUID = 5828432709190949547L;

    private String username;
    private String name;
    private String email;

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

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
