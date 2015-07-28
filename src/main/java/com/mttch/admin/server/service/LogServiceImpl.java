package com.mttch.admin.server.service;

import com.mttch.admin.client.server.log.LogService;
import com.mttch.admin.common.exception.BusinessException;
import com.mttch.admin.common.model.grid.ServerPagingLoadResult;
import com.mttch.admin.common.model.grid.log.AdminLogModel;
import com.mttch.admin.common.model.grid.log.LicenseLogModel;
import com.mttch.admin.server.aop.annotation.Secured;
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
@Secured
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Override
    public PagingLoadResult<AdminLogModel> listAdminLogs(PagingLoadConfig config) throws BusinessException {
        List<EventEntity> entities = logRepository.listEvents(config.getLimit(), config.getOffset());
        List<AdminLogModel> result = new ArrayList<>();

        entities.forEach((e) -> {
            AdminLogModel model = new AdminLogModel();
            model.setId(e.getId());
            model.setKey(Long.toString(e.getId()));
            model.setEvent(e.getEvent());
            model.setUseragent(e.getUseragent());
            model.setCryptonumber(e.getCryptonumber());
            model.setUser(e.getUser());
            model.setDt(TimeUtils.unixTimestampToDate(e.getDt()));
            model.setText(e.getText());
            model.setIp(e.getIp());
            result.add(model);
        });
        return new ServerPagingLoadResult<>(result, logRepository.countEvents(), config.getOffset());
    }

    @Override
    public PagingLoadResult<LicenseLogModel> listLicenseLogs(PagingLoadConfig config) throws BusinessException {
        List<LogEntity> entities = logRepository.listLogs(config.getLimit(), config.getOffset());
        List<LicenseLogModel> models = new ArrayList<>();
        entities.forEach((e) -> {
            LicenseLogModel model = new LicenseLogModel();
            model.setId(e.getId());
            model.setKey(Long.toString(e.getId()));
            model.setMethod(e.getMethod());
            model.setCryptonumber(e.getCryptonumber());
            model.setEvent(e.getEvent());
            model.setText(e.getText());
            model.setDt(TimeUtils.unixTimestampToDate(e.getDt()));
            model.setIp(e.getIp());
            model.setServer(e.getServer());
            model.setActive(e.getActive() == BooleanSetEnum.s1);
            model.setUser(e.getUser());
            models.add(model);
        });
        return new ServerPagingLoadResult<>(models, logRepository.countLogs(), config.getOffset());
    }

}
