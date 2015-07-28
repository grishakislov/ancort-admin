package com.mttch.admin.server.mybatis.mapper.aaa_cts_corp;

import com.mttch.admin.server.mybatis.entity.EventEntity;
import com.mttch.admin.server.mybatis.entity.LogEntity;
import com.mttch.admin.server.mybatis.helpers.BooleanSetEnum;
import com.mttch.admin.server.mybatis.helpers.BooleanSetTypeHandler;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LogRepository {

    @Select("select * from aaa_cts_corp.event " +
            "limit #{limit} offset #{offset}")
    List<EventEntity> listEvents(@Param("limit") int limit, @Param("offset") int offset);

    @Select("select count(*) from aaa_cts_corp.event")
    int countEvents();

    @Select("select * from aaa_cts_corp.log_file " +
            "limit #{limit} offset #{offset}")
    @Results({
            @Result(property = "active", column = "active", javaType = BooleanSetEnum.class, typeHandler = BooleanSetTypeHandler.class)
    })
    List<LogEntity> listLogs(@Param("limit") int limit, @Param("offset") int offset);

    @Select("select count(*) from aaa_cts_corp.log_file")
    int countLogs();

}
