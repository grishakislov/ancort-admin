package com.mttch.admin.server.mybatis.mapper.mail_cts_corp;

import com.mttch.admin.server.mybatis.entity.MailboxEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MailboxDao {

    @Select("select * from mail_cts_corp.mailbox " +
            "limit #{limit} offset #{offset}")
    @ResultMap("listAll-void")
    List<MailboxEntity> list(@Param("limit") int limit, @Param("offset") int offset);

    @Select("select * from mail_cts_corp.mailbox")
    @Results(value = {
            @Result(property = "serverId", column = "server_id"),
            @Result(property = "storageId", column = "storage_id")
    })
    List<MailboxEntity> listAll();

    @Select("select count(*) from mail_cts_corp.mailbox")
    int count();

}
