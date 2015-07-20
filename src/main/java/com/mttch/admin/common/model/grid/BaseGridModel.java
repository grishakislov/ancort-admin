package com.mttch.admin.common.model.grid;

import java.io.Serializable;

public abstract class BaseGridModel implements Serializable {

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
