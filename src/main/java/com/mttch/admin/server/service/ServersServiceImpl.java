package com.mttch.admin.server.service;

import com.mttch.admin.client.server.servers.ServersService;
import com.mttch.admin.common.exception.BusinessException;
import com.mttch.admin.common.model.grid.ServerPagingLoadResult;
import com.mttch.admin.common.model.grid.servers.JabberServerModel;
import com.mttch.admin.common.model.grid.servers.MailServerModel;
import com.mttch.admin.common.model.grid.servers.SipServerModel;
import com.mttch.admin.server.aop.annotation.AuthenticationNeeded;
import com.mttch.admin.server.mybatis.entity.JabberServerEntity;
import com.mttch.admin.server.mybatis.entity.MailServerEntity;
import com.mttch.admin.server.mybatis.entity.SipServerEntity;
import com.mttch.admin.server.mybatis.helpers.BooleanSetEnum;
import com.mttch.admin.server.mybatis.mapper.aaa_cts_corp.ServersRepository;
import com.mttch.admin.server.mybatis.mapper.mail_cts_corp.MailServersDao;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AuthenticationNeeded
public class ServersServiceImpl implements ServersService {

    @Autowired
    private ServersRepository serversRepository;

    @Autowired
    private MailServersDao mailServersDao;

    @Override
    public PagingLoadResult<SipServerModel> listSipServers(PagingLoadConfig config) throws BusinessException {
        List<SipServerEntity> entities = serversRepository.listSipServers(config.getLimit(), config.getOffset());
        List<SipServerModel> models = new ArrayList<>();
        entities.forEach((e) -> {
            SipServerModel model = new SipServerModel();
            model.setKey(String.valueOf(e.getId()));
            model.setServer(e.getServer());
            model.setDescription(e.getDescription());
            model.setActive(e.getActive() == BooleanSetEnum.s1);
            models.add(model);
        });
        return new ServerPagingLoadResult<>(models, serversRepository.countSipServers(), config.getOffset());
    }

    @Override
    public PagingLoadResult<MailServerModel> listMailServers(PagingLoadConfig config) throws BusinessException {
        List<MailServerEntity> entities = mailServersDao.listMailServers(config.getLimit(), config.getOffset());
        List<MailServerModel> models = new ArrayList<>();
        entities.forEach((e) -> {
            MailServerModel model = new MailServerModel();
            model.setKey(String.valueOf(e.getId()));
            model.setId(e.getId());
            model.setIp(e.getIp());
            model.setHostName(e.getHostName());
            model.setPopPort(e.getPopPort());
            model.setPopSecurity(e.getPopSecurity().name());
            model.setSmtpPort(e.getSmtpPort());
            model.setSmtpSecurity(e.getSmtpSecurity().name());
            model.setActive(e.isActive());
            model.setBaseDir(e.getBaseDir());
            model.setStorageNode(e.getStorageNode());
            model.setMaxMailboxes(e.getMaxMailboxes());
            model.setCountMailboxes(e.getCountMailboxes());
            model.setMaxUse(e.getMaxUse());
            model.setCurrentUse(e.getCurrentUse());
            models.add(model);
        });
        return new ServerPagingLoadResult<>(models, mailServersDao.count(), config.getOffset());
    }

    @Override
    public PagingLoadResult<JabberServerModel> listJabberServers(PagingLoadConfig config) throws BusinessException {
        List<JabberServerEntity> entities = serversRepository.listJabberServers(config.getLimit(), config.getOffset());
        List<JabberServerModel> models = new ArrayList<>();
        entities.forEach((e) -> {
            JabberServerModel model = new JabberServerModel();
            model.setKey(String.valueOf(e.getId()));
            model.setId(e.getId());
            model.setAct(e.isAct());
            model.setDescription(e.getDescription());
            model.setJabberport(e.getJabberport());
            model.setJabberserver(e.getJabberserver());
            model.setJabberportssl(e.getJabberportssl());
            model.setJabberserverconf(e.getJabberserverconf());
            models.add(model);
        });
        return new ServerPagingLoadResult<>(models, serversRepository.countJabberServers(), config.getOffset());
    }
}
