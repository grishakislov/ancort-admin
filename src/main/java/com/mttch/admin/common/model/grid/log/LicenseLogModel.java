package com.mttch.admin.common.model.grid.log;

import com.mttch.admin.common.model.grid.BaseGridModel;

public class LicenseLogModel extends BaseGridModel {

    private static final long serialVersionUID = 8728798839460012541L;

    private long id;
    private String method;
    private int cryptonumber;
    private int event;
    private String text;
    private String dt;
    private String ip;
    private String server;
    private boolean active;
    private long user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setCryptonumber(int cryptonumber) {
        this.cryptonumber = cryptonumber;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public String getMethod() {
        return method;
    }

    public int getCryptonumber() {
        return cryptonumber;
    }

    public int getEvent() {
        return event;
    }

    public String getText() {
        return text;
    }

    public String getDt() {
        return dt;
    }

    public String getIp() {
        return ip;
    }

    public String getServer() {
        return server;
    }

    public boolean isActive() {
        return active;
    }

    public long getUser() {
        return user;
    }
}
