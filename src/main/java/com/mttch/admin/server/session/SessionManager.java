package com.mttch.admin.server.session;

import com.mttch.admin.server.AppPropertiesService;
import com.mttch.admin.server.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class SessionManager {

    private ThreadLocal<String> localSessions = new ThreadLocal<>();

    private ConcurrentHashMap<String, Session> sessionsById = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Session> sessionsByLogin = new ConcurrentHashMap<>();

    @Autowired
    private AppPropertiesService appPropertiesService;

    public void addLocalSession(String sessionId) {
        localSessions.set(sessionId);
    }

    public String getLocalSession() {
        return localSessions.get();
    }

    public String bindSession(String userName) {
        String sessionId = getLocalSession();
        Session session = createSession(sessionId, userName);
        sessionsById.put(sessionId, session);
        sessionsByLogin.put(userName, session);
        return sessionId;
    }

    public boolean isSessionActive(String sessionId) {
        if (sessionsById.containsKey(sessionId)) {
            Session session = sessionsById.get(sessionId);
            boolean past = TimeUtils.isPast(session.getExpireTimestamp());
            return !past;
        } else {
            return false;
        }
    }

    public void unbindSession() {
        String sessionId = getLocalSession();
        String login = sessionsById.get(sessionId).getLogin();
        sessionsById.remove(sessionId);
        sessionsByLogin.remove(login);
    }


    public String sessionToUser(String sessionId) {
        return sessionsById.get(sessionId).getLogin();
    }

    private Session createSession(String sessionId, String userName) {
        int sessionExpireSeconds = appPropertiesService.getSessionExpireSeconds();
        long endTimestamp = TimeUtils.future(sessionExpireSeconds);
        Session session = new Session(sessionId, userName, endTimestamp);
        return session;
    }
}
