package com.mttch.admin.server.service;

import com.mttch.admin.server.mybatis.entity.EventEntity;

public interface EventLogger {

    void log(EventEntity value);

    void userLoggedIn(String login);
}
