package com.mttch.admin.common.model.grid.servers;

import com.mttch.admin.common.model.grid.BaseGridModel;

public class JabberServerModel extends BaseGridModel {

    private static final long serialVersionUID = -744842886045367957L;

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

    public void setId(int id) {
        this.id = id;
    }

    public String getJabberserver() {
        return jabberserver;
    }

    public void setJabberserver(String jabberserver) {
        this.jabberserver = jabberserver;
    }

    public String getJabberserverconf() {
        return jabberserverconf;
    }

    public void setJabberserverconf(String jabberserverconf) {
        this.jabberserverconf = jabberserverconf;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getJabberport() {
        return jabberport;
    }

    public void setJabberport(int jabberport) {
        this.jabberport = jabberport;
    }

    public int getJabberportssl() {
        return jabberportssl;
    }

    public void setJabberportssl(int jabberportssl) {
        this.jabberportssl = jabberportssl;
    }

    public boolean isAct() {
        return act;
    }

    public void setAct(boolean act) {
        this.act = act;
    }
}
