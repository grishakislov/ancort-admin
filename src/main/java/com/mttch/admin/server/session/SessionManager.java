package com.mttch.admin.server.session;

import com.google.common.collect.HashMultimap;
import com.mttch.admin.server.AppPropertiesService;
import com.mttch.admin.server.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class SessionManager {

    private ThreadLocal<String> localSessions = new ThreadLocal<>();

    private Map<String, Session> sessionsById = new HashMap<>();
    private HashMultimap<String, Session> sessionsByLogin = HashMultimap.create();

    @Autowired
    private AppPropertiesService appPropertiesService;

    public void addLocalSession(String sessionId) {
        localSessions.set(sessionId);
    }

    public String getLocalSession() {
        return localSessions.get();
    }

    public synchronized String bindSession(String userName) {
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

    public synchronized void unbindSession() {
        String sessionId = getLocalSession();
        String login = sessionsById.get(sessionId).getLogin();
        sessionsById.remove(sessionId);
        Set<Session> sessions = sessionsByLogin.get(login);
        Session find = null;
        for (Session s : sessions) {
            if (s.getId().equals(sessionId)) {
                find = s;
            }
        }
        if (find != null) {
            sessions.remove(find);
        }
    }


    public String sessionToUser(String sessionId) {
        return sessionsById.get(sessionId).getLogin();
    }

    private Session createSession(String sessionId, String userName) {
        int sessionTTLSeconds = appPropertiesService.getSessionTTLSeconds();
        long endTimestamp = TimeUtils.future(sessionTTLSeconds);
        Session session = new Session(sessionId, userName, endTimestamp);
        return session;
    }
}
