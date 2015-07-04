package com.mttch.admin.server.session;

public class Session {

    private String id;
    private String login;
    private long expireTimestamp;

    public Session(String id, String login, long expireTimestamp) {
        this.id = id;
        this.login = login;
        this.expireTimestamp = expireTimestamp;
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public long getExpireTimestamp() {
        return expireTimestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Session session = (Session) o;

        if (!id.equals(session.id)) return false;
        if (!login.equals(session.login)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + login.hashCode();
        return result;
    }
}
