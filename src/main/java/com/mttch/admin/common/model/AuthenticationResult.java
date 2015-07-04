package com.mttch.admin.common.model;

import java.io.Serializable;

public class AuthenticationResult implements Serializable {

    private static final long serialVersionUID = 6438268825103065130L;
    private boolean authenticated;
    private String sessionId;
    private CorpUser corpUser;

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public CorpUser getCorpUser() {
        return corpUser;
    }

    public void setCorpUser(CorpUser corpUser) {
        this.corpUser = corpUser;
    }
}
