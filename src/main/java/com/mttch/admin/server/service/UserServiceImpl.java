package com.mttch.admin.server.service;

import com.mttch.admin.client.server.user.UserService;
import com.mttch.admin.common.model.grid.ServerPagingLoadResult;
import com.mttch.admin.common.model.grid.UserModel;
import com.mttch.admin.server.mybatis.UserDao;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public PagingLoadResult<UserModel> listUsers(PagingLoadConfig config) {
        return new ServerPagingLoadResult<>(userDao.listUsers(config.getLimit(), config.getOffset()), userDao.usersCount(), config.getOffset());
    }


}
