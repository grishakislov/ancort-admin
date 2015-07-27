package com.mttch.admin.server.utils;

import com.mttch.admin.common.authorization.Role;
import com.mttch.admin.common.exception.BusinessException;
import com.mttch.admin.common.exception.OperationResult;

import java.util.List;

public class ExceptionFactory {

    public static BusinessException administratorAlreadyExists(String login) {
        return new BusinessException(OperationResult.ADMINISTRATOR_ACCOUNT_ALREADY_EXISTS,
                "Administrator account already exists: " + login);
    }

    public static BusinessException cannotDeleteCurrentAccount(String login) {
        return new BusinessException(OperationResult.CANNOT_DELETE_CURRENT_ACCOUNT,
                "Cannot delete current account: " + login);
    }

    public static BusinessException cannotDeleteLastAccount(String login) {
        return new BusinessException(OperationResult.CANNOT_DELETE_LAST_ADMINISTRATOR,
                "Cannot delete last administrator account: " + login);
    }

    public static BusinessException sessionExpired() {
        return new BusinessException(OperationResult.SESSION_EXPIRED, "Session expired, please login");
    }

    public static BusinessException notAuthenticated() {
        return new BusinessException(OperationResult.NOT_AUTHENTICATED, "Authentication needed, please login");
    }

    public static BusinessException notAuthorized(List<Role> roles) {
        return new BusinessException(OperationResult.ACCESS_DENIED, "Access denied");
    }
}
