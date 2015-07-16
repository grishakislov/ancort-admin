package com.mttch.admin.server.mybatis.entity;

public class XmppEntity {

    private String username;
    private String plainPassword;
    private String encryptedPassword;
    private String name;
    private String email;
    private String creationDate;
    private String modificationDate;

    public String getUsername() {
        return username;
    }

    public String getPlainPassword() {
        return plainPassword;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getModificationDate() {
        return modificationDate;
    }
}
