package com.mttch.admin.server.service;

import com.mttch.admin.client.server.mailbox.MailboxService;
import com.mttch.admin.common.exception.BusinessException;
import com.mttch.admin.common.model.grid.ServerPagingLoadResult;
import com.mttch.admin.common.model.grid.service.MailboxModel;
import com.mttch.admin.server.aop.annotation.AuthenticationNeeded;
import com.mttch.admin.server.mybatis.entity.MailboxEntity;
import com.mttch.admin.server.mybatis.mapper.mail_cts_corp.MailboxDao;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("mailboxService")
@AuthenticationNeeded
public class MailboxServiceImpl implements MailboxService {

    @Autowired
    private MailboxDao mailboxDao;

    //TODO: Administrator only
    @Override
    public PagingLoadResult<MailboxModel> listMailboxes(PagingLoadConfig config) throws BusinessException {
        List<MailboxEntity> entities = mailboxDao.list(config.getLimit(), config.getOffset());
        List<MailboxModel> result = new ArrayList<>();
        entities.forEach((entity) -> {
            MailboxModel model = new MailboxModel();
            model.setKey(entity.getUsername());
            model.setLogin(entity.getSiplogin());
            model.setUsername(entity.getUsername());
            model.setPassword(entity.getPassword());
            model.setQuota(entity.getQuota());
            model.setMaildir(entity.getMaildir());
            result.add(model);
        });
        return new ServerPagingLoadResult<>(result, mailboxDao.count(), config.getOffset());
    }
}
