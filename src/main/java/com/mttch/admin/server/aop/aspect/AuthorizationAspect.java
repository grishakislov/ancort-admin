package com.mttch.admin.server.aop.aspect;

import com.mttch.admin.common.authorization.Role;
import com.mttch.admin.common.exception.BusinessException;
import com.mttch.admin.common.model.CorpUser;
import com.mttch.admin.server.aop.annotation.AllowedRole;
import com.mttch.admin.server.service.auth.AuthenticationService;
import com.mttch.admin.server.session.SessionManager;
import com.mttch.admin.server.utils.ExceptionFactory;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class AuthorizationAspect {

    @Autowired
    private SessionManager sessionManager;

    @Autowired
    private AuthenticationService authenticationService;

    @Before(value = "@within(allowedRole) || @annotation(allowedRole)")
    public void checkAuthorization(AllowedRole allowedRole) throws BusinessException {
        CorpUser corpUser = authenticationService.getCorpUser(sessionManager.currentUserLogin());
        List<Role> roles = Arrays.asList(allowedRole.value());
        if (!corpUser.hasOneRoleOf(roles)) {
            throw ExceptionFactory.notAuthorized(roles);
        }
    }
}
