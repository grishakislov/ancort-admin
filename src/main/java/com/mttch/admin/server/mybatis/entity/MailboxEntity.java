package com.mttch.admin.server.mybatis.entity;

public class MailboxEntity {

    private String username;
    private String password;
    private long serverId;
    private long storageId;
    private String siplogin;
    private String maildir;
    private long quota;
    private boolean active;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public long getServerId() {
        return serverId;
    }

    public long getStorageId() {
        return storageId;
    }

    public String getSiplogin() {
        return siplogin;
    }

    public String getMaildir() {
        return maildir;
    }

    public long getQuota() {
        return quota;
    }

    public boolean isActive() {
        return active;
    }
}
