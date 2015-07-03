package com.mttch.admin.server.service;

import com.mttch.admin.client.server.user.UserService;
import com.mttch.admin.common.model.grid.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    public List<UserModel> listUsers(int start, int limit) {
        List<UserModel> list = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            list.add(generateUserModel(i));
        }
        return list;
    }

    private UserModel generateUserModel(int i) {
        UserModel model = new UserModel();
        model.setCreateDate("31/03/2015");
        model.setReceiveDate("31/03/2015 04:40");
        model.setFirstQueryDate("01/07/2015 04:54");
        model.setCryptoNumber(79);
        model.setLogin("Login " + i);
        model.setKey("Login " + i);
        model.setDeviceId("Device ID " + i);
        model.setPlatform("Platform");
        model.setPushToken("Push token " + i);
        model.setLicense(i);
        model.setLinkTable(i);
        return model;
    }

}
