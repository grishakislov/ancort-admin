package com.mttch.admin.server.mybatis.mapper.aaa_cts_corp;

import com.mttch.admin.server.mybatis.entity.JabberServerEntity;
import com.mttch.admin.server.mybatis.entity.SipServerEntity;
import com.mttch.admin.server.mybatis.helpers.BooleanSetEnum;
import com.mttch.admin.server.mybatis.helpers.BooleanSetTypeHandler;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ServersRepository {

    @Select("select * from aaa_cts_corp.sipserver " +
            "limit #{limit} offset #{offset}")
    @Results(value = {
            @Result(property = "active", column = "activ", javaType = BooleanSetEnum.class, typeHandler = BooleanSetTypeHandler.class),
    })
    List<SipServerEntity> listSipServers(@Param("limit") int limit, @Param("offset") int offset);

    @Select("select count(*) from aaa_cts_corp.sipserver")
    int countSipServers();

    @Select("select * from aaa_cts_corp.jabberserver " +
            "limit #{limit} offset #{offset}")
    List<JabberServerEntity> listJabberServers(@Param("limit") int limit, @Param("offset") int offset);

    @Select("select count(*) from aaa_cts_corp.jabberserver")
    int countJabberServers();


}
