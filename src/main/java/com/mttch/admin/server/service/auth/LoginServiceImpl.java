package com.mttch.admin.server.service.auth;

import com.mttch.admin.client.server.login.LoginService;
import com.mttch.admin.common.model.AuthenticationResult;
import com.mttch.admin.common.model.CorpUser;
import com.mttch.admin.server.conf.AppPropertiesService;
import com.mttch.admin.server.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SessionManager sessionManager;

    @Autowired
    private AppPropertiesService appPropertiesService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostConstruct
    private void init() {
        System.out.println();
    }

    public AuthenticationResult authenticate(String login, String password) {
        AuthenticationResult response = new AuthenticationResult();

        boolean result = authenticationService.authenticate(login, password);

        if (!result) {
            response.setAuthenticated(false);
            return response;
        }

        CorpUser user = authenticationService.getCorpUser(login);
        response.setAuthenticated(true);
        response.setCorpUser(user);

        String sessionId = sessionManager.bindSession(login);
        response.setSessionId(sessionId);
        return response;
    }

    @Override
    public AuthenticationResult authenticate(String sessionId) {
        AuthenticationResult response = new AuthenticationResult();

        if (appPropertiesService.isUseAutoLogin() || sessionManager.isSessionActive(sessionId)) {
            String user;
            if (appPropertiesService.isUseAutoLogin()) {
                user = appPropertiesService.getAutoLoginAccount();
                sessionManager.bindSession(user);
            } else {
                user = sessionManager.sessionToUser(sessionId);
            }
            CorpUser corpUser = authenticationService.getCorpUser(user);
            response.setAuthenticated(true);
            response.setSessionId(sessionId);
            response.setCorpUser(corpUser);
        } else {
            response.setAuthenticated(false);
        }

        return response;
    }

    @Override
    public AuthenticationResult autoAuthenticate() {
        AuthenticationResult result = new AuthenticationResult();
        if (appPropertiesService.isUseAutoLogin()) {
            result.setAuthenticated(true);
            CorpUser corpUser = authenticationService.getCorpUser(appPropertiesService.getAutoLoginAccount());
            result.setCorpUser(corpUser);
            sessionManager.bindSession(corpUser.getLogin());
            result.setSessionId(sessionManager.getLocalSession());
        } else {
            result.setAuthenticated(false);
        }
        return result;
    }

    @Override
    public void logout(String login) {
        sessionManager.unbindSession();
    }

}
