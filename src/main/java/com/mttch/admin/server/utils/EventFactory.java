package com.mttch.admin.server.utils;

import com.mttch.admin.server.mybatis.entity.EventEntity;
import com.mttch.admin.server.session.SessionManager;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class EventFactory {

    @Autowired
    private SessionManager sessionManager;

    public EventEntity userLoggedInEvent(String user) {
        EventEntity eventEntity = prepareEventEntity();
        eventEntity.setEvent(EventEntity.Event.userLoggedIn.getCode());
        eventEntity.setUser(sessionManager.currentUserLogin());
        eventEntity.setText("User logged in: " + user);
        return eventEntity;
    }

    private EventEntity prepareEventEntity() {
        EventEntity eventEntity = new EventEntity();
        HttpServletRequest request = sessionManager.getCurrentRequest();

        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }

        eventEntity.setDt(TimeUtils.getUnixSeconds());
        eventEntity.setUseragent(StringEscapeUtils.escapeHtml(request.getHeader("User-Agent")));
        eventEntity.setIp(ipAddress);
        return eventEntity;
    }

}
