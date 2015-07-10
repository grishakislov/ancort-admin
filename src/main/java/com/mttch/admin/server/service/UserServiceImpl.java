package com.mttch.admin.server.service;

import com.mttch.admin.client.server.user.UserService;
import com.mttch.admin.common.model.grid.ServerPagingLoadResult;
import com.mttch.admin.common.model.grid.UserModel;
import com.mttch.admin.server.mybatis.entity.LicenseEntity;
import com.mttch.admin.server.mybatis.mapper.aaa_cts_corp.LicenseDao;
import com.mttch.admin.server.utils.TimeUtils;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private LicenseDao licenseDao;

    public PagingLoadResult<UserModel> listUsers(PagingLoadConfig config) {
        List<LicenseEntity> licenses = licenseDao.list(config.getLimit(), config.getOffset());
        List<UserModel> models = licenseEntitiesToModels(licenses);
        return new ServerPagingLoadResult<>(models, licenseDao.count(), config.getOffset());
    }

    private List<UserModel> licenseEntitiesToModels(List<LicenseEntity> licenses) {
        List<UserModel> result = new ArrayList<>();
        for (LicenseEntity entity : licenses) {
            result.add(licenseEntityToModel(entity));
        }
        return result;
    }


    private UserModel licenseEntityToModel(LicenseEntity entity) {
        UserModel result = new UserModel();

        result.setCreateDate(TimeUtils.unixTimestampToDate(entity.getTimeCreate()));
        result.setReceiveDate(TimeUtils.unixTimestampToDate(entity.getTimeLicenseStart()));
        result.setFirstRequestDate(TimeUtils.unixTimestampToDate(entity.getTimeLicenseStart()));
        result.setCryptoNumber(entity.getCryptonumber());
        result.setLogin(entity.getSiplogin());
        result.setKey(entity.getSiplogin());
        result.setDeviceId(entity.getDevice());
        result.setPlatform(entity.getPlatform().name());
        result.setPushToken(entity.getDeviceToken());
        result.setLicense(entity.getVersion());
        result.setLinkTable(79); //TODO

        return result;
    }

    @Override
    public void deleteUser(String login) {
//        userDao.deleteUser(login);
    }
}
