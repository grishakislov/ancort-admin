package com.mttch.admin.server.mybatis;

import com.mttch.admin.common.model.CorpUser;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public boolean checkPassword(String login, String password) {
        return true;
    }

    public CorpUser getUser(String login) {
        CorpUser result = new CorpUser();
        result.setLogin(login);
        return result;
    }

}
