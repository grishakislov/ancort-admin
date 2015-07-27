package com.mttch.admin.common.model;

import com.mttch.admin.common.authorization.Role;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CorpUser implements Serializable {

    private static final long serialVersionUID = 4224562138489171169L;
    private String login;

    private List<Role> roles = new ArrayList<>();

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean hasOneRoleOf(List<Role> value) {
        for (Role role : value) {
            if (roles.contains(role)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasRole(Role value) {
        return roles.contains(value);
    }
}
