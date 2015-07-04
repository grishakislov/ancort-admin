package com.mttch.admin.client;

import com.mttch.admin.common.model.CorpUser;

public class AppContext {

    private static CorpUser user;

    public static CorpUser getUser() {
        return user;
    }

    public static void setUser(CorpUser value) {
        user = value;
    }

    public static void logout() {
        user = null;
    }

}
