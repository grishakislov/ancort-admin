package com.mttch.admin.server.mybatis.entity;

public class EventEntity {

    private long id;
    private int event;
    private String useragent;
    private int cryptonumber;
    private String user;
    private int dt;
    private String text;
    private String ip;

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

    public int getDt() {
        return dt;
    }

    public String getText() {
        return text;
    }

    public String getIp() {
        return ip;
    }
}
