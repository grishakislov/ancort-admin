package com.mttch.admin.server.mybatis.entity;

public class SipServerEntity {

    private int id;
    private String server;
    private String description;
    private boolean active;

    public int getId() {
        return id;
    }

    public String getServer() {
        return server;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }
}
