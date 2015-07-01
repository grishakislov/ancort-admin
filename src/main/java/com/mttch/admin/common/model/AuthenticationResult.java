package com.mttch.admin.common.model;

import java.io.Serializable;

public class AuthenticationResult implements Serializable {

    private static final long serialVersionUID = 6438268825103065130L;
    private boolean authenticated;
    private CorpUser corpUser;

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public CorpUser getCorpUser() {
        return corpUser;
    }

    public void setCorpUser(CorpUser corpUser) {
        this.corpUser = corpUser;
    }
}
