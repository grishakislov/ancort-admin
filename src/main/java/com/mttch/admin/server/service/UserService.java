package com.mttch.admin.server.service;

import com.mttch.admin.common.model.grid.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public List<UserModel> listUsers(int start, int limit) {
        List<UserModel> list = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            list.add(generateUserModel());
        }
        return list;
    }

    private UserModel generateUserModel() {
        UserModel model = new UserModel();
        model.setCreateDate("31/03/2015");
        model.setReceiveDate("31/03/2015 04:40");
        model.setFirstQueryDate("01/07/2015 04:54");
        return model;
    }

}
