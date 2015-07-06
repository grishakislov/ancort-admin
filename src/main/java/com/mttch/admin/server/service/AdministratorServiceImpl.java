package com.mttch.admin.server.service;

import com.mttch.admin.client.server.administrator.AdministratorService;
import com.mttch.admin.common.model.grid.AdministratorModel;
import com.mttch.admin.common.model.grid.ServerPagingLoadResult;
import com.mttch.admin.server.mybatis.AdministratorDao;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("administratorService")
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorDao administratorDao;

    @Override
    public PagingLoadResult<AdministratorModel> listAdministrators(PagingLoadConfig config) {
        return new ServerPagingLoadResult<>(administratorDao.listAdministrators(config.getLimit(), config.getOffset()), administratorDao.administratorsCount(), config.getOffset());
    }
}
