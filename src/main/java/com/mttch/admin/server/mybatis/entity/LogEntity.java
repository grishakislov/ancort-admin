package com.mttch.admin.server.mybatis.entity;

import com.mttch.admin.server.mybatis.helpers.BooleanSetEnum;

public class LogEntity {

    private long id;
    private String method;
    private int cryptonumber;
    private int event;
    private String text;
    private long dt;
    private String ip;
    private String server;
    private BooleanSetEnum active;
    private long user;

    public long getId() {
        return id;
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

    public long getDt() {
        return dt;
    }

    public String getIp() {
        return ip;
    }

    public String getServer() {
        return server;
    }

    public BooleanSetEnum getActive() {
        return active;
    }

    public long getUser() {
        return user;
    }
}
