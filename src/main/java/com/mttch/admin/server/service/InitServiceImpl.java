package com.mttch.admin.server.service;

import com.mttch.admin.client.server.init.InitService;
import com.mttch.admin.common.model.InitData;
import com.mttch.admin.server.AppPropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("initService")
public class InitServiceImpl implements InitService {

    @Autowired
    private AppPropertiesService appPropertiesService;

    public InitData init() {
        InitData data = new InitData();
        //TODO
        return data;
    }


}
