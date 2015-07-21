package com.mttch.admin.common.model.grid;

public class UserModel extends BaseGridModel {

    private static final long serialVersionUID = -1731350507643733467L;

    private String createDate;
    private String receiveDate;
    private String firstRequestDate;
    private int cryptoNumber;
    private String login;
    private String deviceId;
    private String platform;
    private String pushToken;
    private int license;
    private int linkTable;

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getFirstRequestDate() {
        return firstRequestDate;
    }

    public void setFirstRequestDate(String firstRequestDate) {
        this.firstRequestDate = firstRequestDate;
    }

    public int getCryptoNumber() {
        return cryptoNumber;
    }

    public void setCryptoNumber(int cryptoNumber) {
        this.cryptoNumber = cryptoNumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPushToken() {
        return pushToken;
    }

    public void setPushToken(String pushToken) {
        this.pushToken = pushToken;
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }

    public int getLinkTable() {
        return linkTable;
    }

    public void setLinkTable(int linkTable) {
        this.linkTable = linkTable;
    }

}
