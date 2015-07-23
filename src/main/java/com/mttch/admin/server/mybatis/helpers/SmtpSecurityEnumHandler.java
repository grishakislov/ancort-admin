package com.mttch.admin.server.mybatis.helpers;

import com.mttch.admin.server.mybatis.entity.MailServerEntity;
import org.apache.ibatis.type.EnumTypeHandler;

public class SmtpSecurityEnumHandler extends EnumTypeHandler<MailServerEntity.SmtpSecurity> {

    public SmtpSecurityEnumHandler() {
        super(MailServerEntity.SmtpSecurity.class);
    }
}
