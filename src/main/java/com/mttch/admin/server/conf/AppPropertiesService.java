package com.mttch.admin.server.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppPropertiesService {

    @Value("${app.useAutoLogin}")
    private boolean useAutoLogin;

    @Value("${app.autoLoginAccount}")
    private String autoLoginAccount;

    @Value("${app.sessionTTLSeconds}")
    private int sessionTTLSeconds;

    public boolean isUseAutoLogin() {
        return useAutoLogin;
    }

    public String getAutoLoginAccount() {
        return autoLoginAccount;
    }

    public int getSessionTTLSeconds() {
        return sessionTTLSeconds;
    }
}
