package com.mttch.admin.common.model.grid.service;

import java.io.Serializable;

public class MailboxModel implements Serializable {

    private static final long serialVersionUID = -6469746734793266224L;

    private String login;
    private String username;
    private String password;
    private long quota;
    private String maildir;

    private String key;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMaildir() {
        return maildir;
    }

    public void setMaildir(String maildir) {
        this.maildir = maildir;
    }

    public long getQuota() {
        return quota;
    }

    public void setQuota(long quota) {
        this.quota = quota;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
