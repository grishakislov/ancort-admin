package com.mttch.admin.server.utils;

import com.mttch.admin.common.exception.BusinessException;
import com.mttch.admin.common.exception.OperationResult;

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

}
