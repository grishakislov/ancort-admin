package com.mttch.admin.server.mybatis.entity;

public class AdminUserEntity {

    private int id;
    private String login;
    private String password;
    private int site;
    private String name;
    private String surname;
    private String email;
    private String desc;
    private long time;
    private boolean status;
    private boolean accessTech;
    private boolean accessServer;
    private boolean accessSipserverEdit;
    private boolean accessIddeviceEdit;
    private boolean accessPushEdit;
    private boolean accessServerTest;
    private boolean accessDelete;
    private boolean accessSupport;
    private boolean accessBlock;
    private boolean pub;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSite() {
        return site;
    }

    public void setSite(int site) {
        this.site = site;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isAccessTech() {
        return accessTech;
    }

    public void setAccessTech(boolean accessTech) {
        this.accessTech = accessTech;
    }

    public boolean isAccessServer() {
        return accessServer;
    }

    public void setAccessServer(boolean accessServer) {
        this.accessServer = accessServer;
    }

    public boolean isAccessSipserverEdit() {
        return accessSipserverEdit;
    }

    public void setAccessSipserverEdit(boolean accessSipserverEdit) {
        this.accessSipserverEdit = accessSipserverEdit;
    }

    public boolean isAccessIddeviceEdit() {
        return accessIddeviceEdit;
    }

    public void setAccessIddeviceEdit(boolean accessIddeviceEdit) {
        this.accessIddeviceEdit = accessIddeviceEdit;
    }

    public boolean isAccessPushEdit() {
        return accessPushEdit;
    }

    public void setAccessPushEdit(boolean accessPushEdit) {
        this.accessPushEdit = accessPushEdit;
    }

    public boolean isAccessServerTest() {
        return accessServerTest;
    }

    public void setAccessServerTest(boolean accessServerTest) {
        this.accessServerTest = accessServerTest;
    }

    public boolean isAccessDelete() {
        return accessDelete;
    }

    public void setAccessDelete(boolean accessDelete) {
        this.accessDelete = accessDelete;
    }

    public boolean isAccessSupport() {
        return accessSupport;
    }

    public void setAccessSupport(boolean accessSupport) {
        this.accessSupport = accessSupport;
    }

    public boolean isAccessBlock() {
        return accessBlock;
    }

    public void setAccessBlock(boolean accessBlock) {
        this.accessBlock = accessBlock;
    }

    public boolean isPub() {
        return pub;
    }

    public void setPub(boolean pub) {
        this.pub = pub;
    }
}
