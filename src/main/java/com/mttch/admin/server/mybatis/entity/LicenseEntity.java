package com.mttch.admin.server.mybatis.entity;

import com.mttch.admin.server.mybatis.helpers.BooleanSetEnum;

public class LicenseEntity {

    private long id;
    private String device;
    private int cryptonumber;
    private String cryptonetwork;
    private int cryptolevel;
    private String btSn;
    private String name;
    private String number;
    private boolean certType;
    private String sippass;
    private String siplogin;
    private String sipserver;
    private boolean isSandbox;

    private Platform platform;

    private String deviceToken;
    private String singleToken;

    private BooleanSetEnum sub;

    private long subtime;
    private long asteriskId;
    private boolean block;
    private String lmd5;
    private int version;
    private long unixTimeBlock;
    private long unixtime;
    private long timeCreate;
    private long timeLicenseStart;
    private long timeLicenseEnd;
    private long timeRequest;

    public long getId() {
        return id;
    }

    public String getDevice() {
        return device;
    }

    public int getCryptonumber() {
        return cryptonumber;
    }

    public String getCryptonetwork() {
        return cryptonetwork;
    }

    public int getCryptolevel() {
        return cryptolevel;
    }

    public String getBtSn() {
        return btSn;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public boolean isCertType() {
        return certType;
    }

    public String getSippass() {
        return sippass;
    }

    public String getSiplogin() {
        return siplogin;
    }

    public String getSipserver() {
        return sipserver;
    }

    public boolean isSandbox() {
        return isSandbox;
    }

    public Platform getPlatform() {
        return platform;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public String getSingleToken() {
        return singleToken;
    }

    public long getSubtime() {
        return subtime;
    }

    public long getAsteriskId() {
        return asteriskId;
    }

    public boolean isBlock() {
        return block;
    }

    public String getLmd5() {
        return lmd5;
    }

    public int getVersion() {
        return version;
    }

    public long getUnixTimeBlock() {
        return unixTimeBlock;
    }

    public long getUnixtime() {
        return unixtime;
    }

    public long getTimeCreate() {
        return timeCreate;
    }

    public long getTimeLicenseStart() {
        return timeLicenseStart;
    }

    public long getTimeLicenseEnd() {
        return timeLicenseEnd;
    }

    public long getTimeRequest() {
        return timeRequest;
    }

    public BooleanSetEnum getSub() {
        return sub;
    }

    public enum Platform {
        ios, android, windowsphone, officegate
    }

}
