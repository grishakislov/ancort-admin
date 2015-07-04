package com.mttch.admin.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppPropertiesService {

    @Value("${app.useAutoLogin}")
    private boolean useAutoLogin;

    @Value("${app.autoLoginAccount}")
    private String autoLoginAccount;

    @Value("${app.sessionExpireSeconds}")
    private int sessionExpireSeconds;

    public boolean isUseAutoLogin() {
        return useAutoLogin;
    }

    public String getAutoLoginAccount() {
        return autoLoginAccount;
    }

    public int getSessionExpireSeconds() {
        return sessionExpireSeconds;
    }
}
