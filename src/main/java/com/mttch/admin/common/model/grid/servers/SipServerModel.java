package com.mttch.admin.common.model.grid.servers;

import com.mttch.admin.common.model.grid.BaseGridModel;

public class SipServerModel extends BaseGridModel {

    private static final long serialVersionUID = -5927815006704876275L;

    private int id;
    private String server;
    private String description;
    private boolean active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
