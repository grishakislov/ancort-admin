package com.mttch.admin.server.service;

import com.mttch.admin.common.model.CorpUser;
import com.mttch.admin.server.mybatis.entity.AdminUserEntity;
import com.mttch.admin.server.mybatis.mapper.admin_corp.AdminUsersDao;
import com.mttch.admin.server.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AdminUsersDao adminUsersDao;

    public boolean authenticate(String login, String password) {
        AdminUserEntity entity = adminUsersDao.getAdminUser(login);
        if (entity == null) {
            return false;
        }
        String hash = PasswordUtil.hash(password);
        if (!entity.getPassword().equals(hash)) {
            return false;
        }
        return true;
    }

    public AdminUserEntity getUser(String login) {
        return adminUsersDao.getAdminUser(login);
    }

    public CorpUser getCorpUser(String login) {
        return entityToCorpUser(adminUsersDao.getAdminUser(login));
    }

    private CorpUser entityToCorpUser(AdminUserEntity adminUser) {
        CorpUser user = new CorpUser();
        user.setLogin(adminUser.getLogin());
        //TODO: Complete
        return user;
    }

}
