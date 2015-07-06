package com.mttch.admin.server.mybatis;

import com.mttch.admin.common.model.CorpUser;
import com.mttch.admin.common.model.grid.UserModel;
import com.mttch.admin.server.utils.TimeUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    private List<UserModel> users;
    private final int TOTAL_USERS = 110;

    public boolean checkPassword(String login, String password) {
        return true;
    }

    @PostConstruct
    private void init() {
        users = new ArrayList<>();
        for (int i = 0; i < TOTAL_USERS; i++) {
            users.add(generateUserModel(i));
        }
    }

    public CorpUser getUser(String login) {
        CorpUser result = new CorpUser();
        result.setLogin(login);
        return result;
    }

    public List<UserModel> listUsers(int limit, int offset) {
        List<UserModel> list = new ArrayList<>();
        int last = offset + limit > users.size() ? users.size() : offset + limit;
        for (int i = offset; i < last; i++) {
            list.add(users.get(i));
        }
        return list;
    }

    private UserModel generateUserModel(int i) {
        int num = i + 1;
        double randomSeconds1 = 86400 * i * Math.random();
        double randomSeconds2 = 86400 * i * Math.random();
        double randomSeconds3 = 86400 * i * Math.random();
        long currentSeconds = TimeUtils.getUnixSeconds();
        long createTime = currentSeconds + (long) randomSeconds1;
        long receiveTime = currentSeconds + (long) randomSeconds2;
        long fqTime = currentSeconds + (long) randomSeconds3;
        String createDate = TimeUtils.unixTimestampToDate(createTime);
        String receiveDate = TimeUtils.unixTimestampToDate(receiveTime);
        String fqDate = TimeUtils.unixTimestampToDate(fqTime);

        UserModel model = new UserModel();
        model.setCreateDate(createDate);
        model.setReceiveDate(receiveDate);
        model.setFirstQueryDate(fqDate);
        model.setCryptoNumber(79);
        model.setLogin("Login " + num);
        model.setKey("Login " + num);
        model.setDeviceId("Device ID " + num);
        model.setPlatform("Platform");
        model.setPushToken("Push token " + num);
        model.setLicense(num);
        model.setLinkTable(num);
        return model;
    }

    public int usersCount() {
        return TOTAL_USERS;
    }
}
