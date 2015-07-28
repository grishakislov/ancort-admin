package com.mttch.admin.server.service;

import com.mttch.admin.client.server.xmpp.XmppService;
import com.mttch.admin.common.exception.BusinessException;
import com.mttch.admin.common.model.grid.ServerPagingLoadResult;
import com.mttch.admin.common.model.grid.service.XmppModel;
import com.mttch.admin.server.aop.annotation.Secured;
import com.mttch.admin.server.mybatis.entity.XmppEntity;
import com.mttch.admin.server.mybatis.mapper.openfire_corp.OpenfireDao;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("xmppService")
@Secured
public class XmppServiceImpl implements XmppService {

    @Autowired
    private OpenfireDao openfireDao;

    @Override
    public PagingLoadResult<XmppModel> listXmppUsers(PagingLoadConfig config) throws BusinessException {
        List<XmppEntity> entities = openfireDao.listUsers(config.getLimit(), config.getOffset());
        List<XmppModel> result = new ArrayList<>();

        entities.forEach((e) -> {
            XmppModel model = new XmppModel();
            model.setKey(e.getUsername());
            model.setUsername(e.getUsername());
            model.setName(e.getName());
            model.setEmail(e.getEmail());
            result.add(model);
        });

        return new ServerPagingLoadResult<>(result, openfireDao.countUsers(), config.getOffset());
    }
}
