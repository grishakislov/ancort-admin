package com.mttch.admin.server.service;

import com.mttch.admin.client.server.init.InitService;
import com.mttch.admin.common.exception.BusinessException;
import com.mttch.admin.common.model.InitData;
import com.mttch.admin.server.AppPropertiesService;
import com.mttch.admin.server.aop.annotation.AuthenticationNeeded;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("initService")
@AuthenticationNeeded
public class InitServiceImpl implements InitService {

    @Autowired
    private AppPropertiesService appPropertiesService;

    public InitData init() throws BusinessException {
        InitData data = new InitData();
        //TODO
        return data;
    }


}
