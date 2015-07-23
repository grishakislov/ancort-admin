package com.mttch.admin.server.mybatis.entity;

public class JabberServerEntity {

    private int id;
    private String jabberserver;
    private String jabberserverconf;
    private String description;
    private int jabberport;
    private int jabberportssl;
    private boolean act;

    public int getId() {
        return id;
    }

    public String getJabberserver() {
        return jabberserver;
    }

    public String getJabberserverconf() {
        return jabberserverconf;
    }

    public String getDescription() {
        return description;
    }

    public int getJabberport() {
        return jabberport;
    }

    public int getJabberportssl() {
        return jabberportssl;
    }

    public boolean isAct() {
        return act;
    }
}
