package com.mttch.admin.server.service;

import com.mttch.admin.client.server.login.LoginService;
import com.mttch.admin.common.model.AuthenticationResult;
import com.mttch.admin.common.model.CorpUser;
import com.mttch.admin.server.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SessionManager sessionManager;

    public AuthenticationResult authenticate(String login, String password) {
        AuthenticationResult response = new AuthenticationResult();
        if (!login.equals("admin")) {
            response.setAuthenticated(false);
            return response;
        }

        CorpUser user = new CorpUser();
        user.setLogin(login);
        response.setAuthenticated(true);
        response.setCorpUser(user);

        String sessionId = sessionManager.getLocalSession();
        sessionManager.bindSession(sessionId, login);

        return response;
    }

    @Override
    public void logout(String login) {
        sessionManager.unbindSession(sessionManager.getLocalSession());
    }

}
