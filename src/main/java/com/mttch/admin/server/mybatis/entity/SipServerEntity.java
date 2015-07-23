package com.mttch.admin.server.mybatis.entity;

import com.mttch.admin.server.mybatis.helpers.BooleanSetEnum;

public class SipServerEntity {

    private int id;
    private String server;
    private String description;
    private BooleanSetEnum active;

    public int getId() {
        return id;
    }

    public String getServer() {
        return server;
    }

    public String getDescription() {
        return description;
    }

    public BooleanSetEnum getActive() {
        return active;
    }
}
