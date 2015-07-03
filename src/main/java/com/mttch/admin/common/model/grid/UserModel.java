package com.mttch.admin.common.model.grid;

import java.io.Serializable;

public class UserModel implements Serializable {

    private static final long serialVersionUID = -1731350507643733467L;

    private String createDate;
    private String receiveDate;
    private String firstQueryDate;
    private int cryptoNumber;
    private String login;
    private String deviceId;
    private String platform;
    private String pushToken;
    private int license;
    private int linkTable;

    private String key;

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

    public String getFirstQueryDate() {
        return firstQueryDate;
    }

    public void setFirstQueryDate(String firstQueryDate) {
        this.firstQueryDate = firstQueryDate;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
