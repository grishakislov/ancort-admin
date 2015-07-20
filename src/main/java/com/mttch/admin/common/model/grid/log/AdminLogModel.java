package com.mttch.admin.common.model.grid.log;

import com.mttch.admin.common.model.grid.BaseGridModel;

public class AdminLogModel extends BaseGridModel {

    private static final long serialVersionUID = 6543189921667643056L;

    private long id;
    private int event;
    private String useragent;
    private int cryptonumber;
    private String user;
    private String dt;
    private String text;
    private String ip;

    public void setId(long id) {
        this.id = id;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public void setUseragent(String useragent) {
        this.useragent = useragent;
    }

    public void setCryptonumber(int cryptonumber) {
        this.cryptonumber = cryptonumber;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public long getId() {
        return id;
    }

    public int getEvent() {
        return event;
    }

    public String getUseragent() {
        return useragent;
    }

    public int getCryptonumber() {
        return cryptonumber;
    }

    public String getUser() {
        return user;
    }

    public String getDt() {
        return dt;
    }

    public String getText() {
        return text;
    }

    public String getIp() {
        return ip;
    }
}
