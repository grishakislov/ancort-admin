package com.mttch.admin.server.mybatis.helpers;

import com.mttch.admin.server.mybatis.entity.MailServerEntity;
import org.apache.ibatis.type.EnumTypeHandler;

public class PopSecurityEnumHandler extends EnumTypeHandler<MailServerEntity.PopSecurity> {

    public PopSecurityEnumHandler() {
        super(MailServerEntity.PopSecurity.class);
    }
}
