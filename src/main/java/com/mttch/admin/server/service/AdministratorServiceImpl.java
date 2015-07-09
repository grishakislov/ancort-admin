package com.mttch.admin.server.service;

import com.mttch.admin.client.server.administrator.AdministratorService;
import com.mttch.admin.common.model.grid.AdministratorModel;
import com.mttch.admin.common.model.grid.ServerPagingLoadResult;
import com.mttch.admin.server.mybatis.entity.AdminUserEntity;
import com.mttch.admin.server.mybatis.mapper.admin_corp.AdminUsersDao;
import com.mttch.admin.server.utils.PasswordUtil;
import com.mttch.admin.server.utils.TimeUtils;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("administratorService")
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdminUsersDao adminUsersDao;

    @Override
    public PagingLoadResult<AdministratorModel> listAdministrators(PagingLoadConfig config) {
        List<AdministratorModel> models = entitiesToModels(adminUsersDao.list(config.getLimit(), config.getOffset()));
        return new ServerPagingLoadResult<>(models, adminUsersDao.count(), config.getOffset());
    }

    @Override
    public void deleteAdministrator(String login) {
        adminUsersDao.delete(login);
    }

    @Override
    public void addAdministrator(String name, String password) {
        adminUsersDao.save(createAdministrator(name, password));
    }

    private AdminUserEntity createAdministrator(String name, String password) {
        AdminUserEntity entity = new AdminUserEntity();
        entity.setLogin(name);
        entity.setPassword(PasswordUtil.hash(password));
        entity.setTime(TimeUtils.getUnixSeconds());
        entity.setStatus(true);
        entity.setPub(true);
        return entity;
    }

    private List<AdministratorModel> entitiesToModels(List<AdminUserEntity> entities) {
        List<AdministratorModel> result = new ArrayList<>();
        for (AdminUserEntity entity : entities) {
            result.add(entityToModel(entity));
        }
        return result;
    }

    private AdministratorModel entityToModel(AdminUserEntity entity) {
        AdministratorModel model = new AdministratorModel();
        model.setId(entity.getId());
        model.setKey(entity.getLogin());
        model.setName(entity.getLogin());
        return model;
    }

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
}
