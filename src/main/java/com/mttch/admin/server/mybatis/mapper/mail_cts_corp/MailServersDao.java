package com.mttch.admin.server.mybatis.mapper.mail_cts_corp;

import com.mttch.admin.server.mybatis.entity.MailServerEntity;
import com.mttch.admin.server.mybatis.helpers.PopSecurityEnumHandler;
import com.mttch.admin.server.mybatis.helpers.SmtpSecurityEnumHandler;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface MailServersDao {

/*
    @Select("select * from mail_cts_corp.mailservers " +
            "limit #{limit} offset #{offset}")
    @Results(value = {
            @Result(property = "popPort", column = "PopPort"),
            @Result(property = "popSecurity", column = "PopSecurity", javaType = MailServerEntity.PopSecurity.class, typeHandler = PopSecurityEnumHandler.class),
            @Result(property = "smtpPort", column = "SmtpPort"),
            @Result(property = "smtpSecurity", column = "SmtpSecurity", javaType = MailServerEntity.SmtpSecurity.class, typeHandler = SmtpSecurityEnumHandler.class)
    })
    List<MailServerEntity> listMailServers(@Param("limit") int limit, @Param("offset") int offset);
*/

    @Select("select m.*,l.*,s.*,m.id mid ,l.id lid, s.id sid " +
            "from mail_cts_corp.list_storage_servers as l " +
            "join mail_cts_corp.mailservers as m on m.id = l.server " +
            "join mail_cts_corp.storage as s on s.id = l.storage")
    @Results(value = {
            @Result(property = "popPort", column = "m.PopPort"),
            @Result(property = "popSecurity", column = "m.PopSecurity", javaType = MailServerEntity.PopSecurity.class, typeHandler = PopSecurityEnumHandler.class),
            @Result(property = "smtpPort", column = "m.SmtpPort"),
            @Result(property = "smtpSecurity", column = "m.SmtpSecurity", javaType = MailServerEntity.SmtpSecurity.class, typeHandler = SmtpSecurityEnumHandler.class),
            @Result(property = "baseDir", column = "base_dir"),
            @Result(property = "storageNode", column = "storage_node"),
            @Result(property = "maxMailboxes", column = "max_mailboxes"),
            @Result(property = "countMailboxes", column = "count_mailboxes"),
            @Result(property = "maxUse", column = "max_use"),
            @Result(property = "currentUse", column = "carrent_use"),
    })
    List<MailServerEntity> listMailServers(@Param("limit") int limit, @Param("offset") int offset);

    @Select("select count(1) from mail_cts_corp.mailservers")
    int count();

}