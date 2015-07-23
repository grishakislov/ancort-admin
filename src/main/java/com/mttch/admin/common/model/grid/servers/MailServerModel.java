package com.mttch.admin.common.model.grid.servers;

import com.mttch.admin.common.model.grid.BaseGridModel;

public class MailServerModel extends BaseGridModel {

    private static final long serialVersionUID = 2381931683125864305L;

    private int id;
    private String ip;
    private String hostName;
    private int popPort;
    private String popSecurity;
    private int smtpPort;
    private String smtpSecurity;
    private boolean active;
    private String baseDir;
    private String storageNode;
    private int maxMailboxes;
    private int countMailboxes;
    private int maxUse;
    private int currentUse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getPopPort() {
        return popPort;
    }

    public void setPopPort(int popPort) {
        this.popPort = popPort;
    }

    public String getPopSecurity() {
        return popSecurity;
    }

    public void setPopSecurity(String popSecurity) {
        this.popSecurity = popSecurity;
    }

    public int getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(int smtpPort) {
        this.smtpPort = smtpPort;
    }

    public String getSmtpSecurity() {
        return smtpSecurity;
    }

    public void setSmtpSecurity(String smtpSecurity) {
        this.smtpSecurity = smtpSecurity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getBaseDir() {
        return baseDir;
    }

    public void setBaseDir(String baseDir) {
        this.baseDir = baseDir;
    }

    public String getStorageNode() {
        return storageNode;
    }

    public void setStorageNode(String storageNode) {
        this.storageNode = storageNode;
    }

    public int getMaxMailboxes() {
        return maxMailboxes;
    }

    public void setMaxMailboxes(int maxMailboxes) {
        this.maxMailboxes = maxMailboxes;
    }

    public int getCountMailboxes() {
        return countMailboxes;
    }

    public void setCountMailboxes(int countMailboxes) {
        this.countMailboxes = countMailboxes;
    }

    public int getMaxUse() {
        return maxUse;
    }

    public void setMaxUse(int maxUse) {
        this.maxUse = maxUse;
    }

    public int getCurrentUse() {
        return currentUse;
    }

    public void setCurrentUse(int currentUse) {
        this.currentUse = currentUse;
    }
}
