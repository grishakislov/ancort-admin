package com.mttch.admin.server.mybatis.entity;

public class MailServerEntity {

    private int id;
    private String ip;
    private int popPort;
    private PopSecurity popSecurity;
    private int smtpPort;
    private String hostName;
    private SmtpSecurity smtpSecurity;
    private boolean active;

    private String baseDir;
    private String storageNode;
    private int maxMailboxes;
    private int countMailboxes;
    private int maxUse;
    private int currentUse;

    public enum PopSecurity {
        ssl, none
    }

    public enum SmtpSecurity {
        ssl, tls, none
    }

    public int getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    public int getPopPort() {
        return popPort;
    }

    public PopSecurity getPopSecurity() {
        return popSecurity;
    }

    public int getSmtpPort() {
        return smtpPort;
    }

    public String getHostName() {
        return hostName;
    }

    public SmtpSecurity getSmtpSecurity() {
        return smtpSecurity;
    }

    public boolean isActive() {
        return active;
    }

    public String getBaseDir() {
        return baseDir;
    }

    public String getStorageNode() {
        return storageNode;
    }

    public int getMaxMailboxes() {
        return maxMailboxes;
    }

    public int getCountMailboxes() {
        return countMailboxes;
    }

    public int getMaxUse() {
        return maxUse;
    }

    public int getCurrentUse() {
        return currentUse;
    }
}
