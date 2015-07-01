package com.mttch.admin.server.session;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class SessionManager {

    private ConcurrentHashMap<String, String> sessions = new ConcurrentHashMap<>();
    private ThreadLocal<String> localSessions = new ThreadLocal<>();

    public void addLocalSession(String sessionId) {
        localSessions.set(sessionId);
    }

    public String getLocalSession() {
        return localSessions.get();
    }

    public void bindSession(String sessionId, String userName) {
        sessions.put(sessionId, userName);
    }

    public void unbindSession(String sessionId) {
        sessions.remove(sessionId);
    }


}
