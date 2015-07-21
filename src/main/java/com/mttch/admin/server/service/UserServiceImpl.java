package com.mttch.admin.server.service;

import com.mttch.admin.client.server.user.UserService;
import com.mttch.admin.common.exception.BusinessException;
import com.mttch.admin.common.model.grid.ServerPagingLoadResult;
import com.mttch.admin.common.model.grid.UserModel;
import com.mttch.admin.server.aop.annotation.AuthenticationNeeded;
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
@AuthenticationNeeded
public class UserServiceImpl implements UserService {

    @Autowired
    private LicenseDao licenseDao;

    public PagingLoadResult<UserModel> listUsers(PagingLoadConfig config) throws BusinessException {
        List<LicenseEntity> licenses = licenseDao.list(config.getLimit(), config.getOffset());
        List<UserModel> models = new ArrayList<>();
        licenses.forEach((entity) -> {
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

            models.add(result);
        });
        return new ServerPagingLoadResult<>(models, licenseDao.count(), config.getOffset());
    }

    @Override
    public synchronized void deleteUser(String login) throws BusinessException {
        //TODO: check authorization
        licenseDao.deleteLicense(login);
    }
}
