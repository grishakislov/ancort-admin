package com.mttch.admin.server.service;

import com.mttch.admin.client.server.administrator.AdministratorService;
import com.mttch.admin.common.exception.BusinessException;
import com.mttch.admin.common.model.grid.AdministratorModel;
import com.mttch.admin.common.model.grid.ServerPagingLoadResult;
import com.mttch.admin.server.aop.annotation.Secured;
import com.mttch.admin.server.mybatis.entity.AdminUserEntity;
import com.mttch.admin.server.mybatis.mapper.admin_corp.AdminUsersDao;
import com.mttch.admin.server.session.SessionManager;
import com.mttch.admin.server.utils.ExceptionFactory;
import com.mttch.admin.server.utils.PasswordUtil;
import com.mttch.admin.server.utils.TimeUtils;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("administratorService")
@Secured
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdminUsersDao adminUsersDao;

    @Autowired
    private SessionManager sessionManager;

    @Override
    public PagingLoadResult<AdministratorModel> listAdministrators(PagingLoadConfig config) throws BusinessException {
        List<AdminUserEntity> entities = adminUsersDao.list(config.getLimit(), config.getOffset());
        List<AdministratorModel> models = new ArrayList<>();
        entities.forEach((e -> {
            AdministratorModel model = new AdministratorModel();
            model.setId(e.getId());
            model.setKey(e.getLogin());
            model.setName(e.getLogin());
            models.add(model);
        }));
        return new ServerPagingLoadResult<>(models, adminUsersDao.count(), config.getOffset());
    }

    @Override
    public synchronized void deleteAdministrator(String login) throws BusinessException {
        String currentUserLogin = sessionManager.currentUserLogin();
        if (login.equals(currentUserLogin)) {
            throw ExceptionFactory.cannotDeleteCurrentAccount(login);
        }
        int count = adminUsersDao.count();
        if (count == 1) {
            throw ExceptionFactory.cannotDeleteLastAccount(login);
        }

        adminUsersDao.delete(login);
    }

    @Override
    public void addAdministrator(String name, String password) throws BusinessException {
        AdminUserEntity entity = adminUsersDao.getAdminUser(name);
        if (entity != null) {
            throw ExceptionFactory.administratorAlreadyExists(name);
        }
        adminUsersDao.save(createAdministrator(name, password));
    }

    private AdminUserEntity createAdministrator(String name, String password) {
        AdminUserEntity entity = new AdminUserEntity();
        //TODO: fill it
        entity.setLogin(name);
        entity.setPassword(PasswordUtil.hash(password));
        entity.setSite(0);
        entity.setName("Set me!");
        entity.setSurname("Set me!");
        entity.setEmail("Set me!");
        entity.setDesc("Set me!");
        entity.setTime(TimeUtils.getUnixSeconds());
        entity.setStatus(true);
        entity.setPub(true);
        return entity;
    }

}
