package com.mttch.admin.server.service;

import com.mttch.admin.client.server.log.LogService;
import com.mttch.admin.common.model.grid.ServerPagingLoadResult;
import com.mttch.admin.common.model.grid.log.AdminLogModel;
import com.mttch.admin.common.model.grid.log.LicenseLogModel;
import com.mttch.admin.server.mybatis.entity.EventEntity;
import com.mttch.admin.server.mybatis.entity.LogEntity;
import com.mttch.admin.server.mybatis.helpers.BooleanSetEnum;
import com.mttch.admin.server.mybatis.mapper.aaa_cts_corp.LogRepository;
import com.mttch.admin.server.utils.TimeUtils;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("logService")
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Override
    public PagingLoadResult<AdminLogModel> listAdminLogs(PagingLoadConfig config) {
        List<EventEntity> entities = logRepository.listEvents(config.getLimit(), config.getOffset());
        List<AdminLogModel> result = new ArrayList<>();

        entities.forEach((entity) -> {
            AdminLogModel model = new AdminLogModel();
            model.setId(entity.getId());
            model.setKey(Long.toString(entity.getId()));
            model.setEvent(entity.getEvent());
            model.setUseragent(entity.getUseragent());
            model.setCryptonumber(entity.getCryptonumber());
            model.setUser(entity.getUser());
            model.setDt(TimeUtils.unixTimestampToDate(entity.getDt()));
            model.setText(entity.getText());
            model.setIp(entity.getIp());
            result.add(model);
        });
        return new ServerPagingLoadResult<>(result, logRepository.countEvents(), config.getOffset());
    }

    @Override
    public PagingLoadResult<LicenseLogModel> listLicenseLogs(PagingLoadConfig config) {
        List<LogEntity> entities = logRepository.listLogs(config.getLimit(), config.getOffset());
        List<LicenseLogModel> models = new ArrayList<>();
        entities.forEach((entity) -> {
            LicenseLogModel model = new LicenseLogModel();
            model.setId(entity.getId());
            model.setKey(Long.toString(entity.getId()));
            model.setMethod(entity.getMethod());
            model.setCryptonumber(entity.getCryptonumber());
            model.setEvent(entity.getEvent());
            model.setText(entity.getText());
            model.setDt(TimeUtils.unixTimestampToDate(entity.getDt()));
            model.setIp(entity.getIp());
            model.setServer(entity.getServer());
            model.setActive(entity.getActive() == BooleanSetEnum.s1);
            model.setUser(entity.getUser());
            models.add(model);
        });
        return new ServerPagingLoadResult<>(models, logRepository.countLogs(), config.getOffset());
    }

}
