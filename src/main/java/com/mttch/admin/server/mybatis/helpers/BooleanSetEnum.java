package com.mttch.admin.server.mybatis.helpers;

public enum BooleanSetEnum {

    s0("0"),
    s1("1");

    private String def;

    BooleanSetEnum(String def) {
        this.def = def;
    }

    public String getDef() {
        return def;
    }

    public static BooleanSetEnum getByString(String value) {
        for (int i = 0; i < BooleanSetEnum.values().length; i++) {
            BooleanSetEnum current = BooleanSetEnum.values()[i];
            if (current.getDef().equals(value)) {
                return current;
            }
        }
        return null;
    }


}
