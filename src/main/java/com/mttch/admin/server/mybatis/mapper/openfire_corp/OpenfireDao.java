package com.mttch.admin.server.mybatis.mapper.openfire_corp;

import com.mttch.admin.server.mybatis.entity.XmppEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OpenfireDao {


    @Select("select * from openfire_corp.ofUser " +
            "limit #{limit} offset #{offset}")
    List<XmppEntity> listUsers(@Param("limit") int limit, @Param("offset") int offset);

    @Select("select count(1) from openfire_corp.ofUser")
    int countUsers();

}
