package com.mttch.admin.common.model.grid;

public class AdministratorModel extends BaseGridModel {

    private static final long serialVersionUID = -737466183525227584L;

    private int id;
    private String name;
    private String online;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

}
