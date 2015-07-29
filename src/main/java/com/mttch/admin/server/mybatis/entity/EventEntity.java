package com.mttch.admin.server.mybatis.entity;

import java.util.HashMap;
import java.util.Map;

public class EventEntity {

    private long id;
    private int event;
    private String useragent;
    private int cryptonumber;
    private String user;
    private long dt;
    private String text;
    private String ip;

    public enum Event {
        userLoggedIn(15);

        private int code;

        Event(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public static Event getByCode(int code) {
            for (Event event : values()) {
                if (event.getCode() == code) {
                    return event;
                }
            }
            return null;
        }
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

    public void setDt(long dt) {
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

    public long getDt() {
        return dt;
    }

    public String getText() {
        return text;
    }

    public String getIp() {
        return ip;
    }
}
