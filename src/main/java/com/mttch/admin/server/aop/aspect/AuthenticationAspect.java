package com.mttch.admin.server.aop.aspect;

import com.mttch.admin.common.exception.BusinessException;
import com.mttch.admin.server.session.SessionManager;
import com.mttch.admin.server.utils.ExceptionFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {

    @Autowired
    private SessionManager sessionManager;

    @Before(value = "@within(com.mttch.admin.server.aop.annotation.AuthenticationNeeded) || " +
            "@annotation(com.mttch.admin.server.aop.annotation.AuthenticationNeeded)")
    public void checkDisallowedRunMode(JoinPoint joinPoint) throws BusinessException {
        String sessionId = sessionManager.getLocalSession();
        if (sessionManager.sessionExists(sessionId)) {
            if (!sessionManager.isSessionActive(sessionId)) {
                throw ExceptionFactory.sessionExpired();
            }
        } else {
            throw ExceptionFactory.notAuthenticated();
        }
    }
}
