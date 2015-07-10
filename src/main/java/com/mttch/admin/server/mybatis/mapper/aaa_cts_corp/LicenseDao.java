package com.mttch.admin.server.mybatis.mapper.aaa_cts_corp;

import com.mttch.admin.server.mybatis.entity.LicenseEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface LicenseDao {

    @Select("select " +
            "id, device, cryptonumber, cryptonetwork, cryptolevel, bt_sn, name, number, cert_type, sippass, siplogin, sipserver, is_sandbox, platform, device_token, single-token, sub, subtime, asterisk_id, block, lmd5, version, unixtime_block, unixtime, time_create, time_license_start, time_license_end, time_request " +
            "from aaa_cts_corp.license " +
            "limit #{limit} offset #{offset}")
    @ResultMap("listAll-void")
    List<LicenseEntity> list(@Param("limit") int limit, @Param("offset") int offset);

    @Select("select count(1) from aaa_cts_corp.license")
    int count();

    @Select("select * from aaa_cts_corp.license")
    @Results(value = {
            @Result(property = "btSn", column = "bt_sn"),
            @Result(property = "certType", column = "cert_type"),
            @Result(property = "isSandbox", column = "is_sandbox"),
            @Result(property = "deviceToken", column = "device_token"),
            @Result(property = "singleToken", column = "single_token"),
            @Result(property = "asteriskId", column = "asterisk_id"),
            @Result(property = "unixTimeBlock", column = "unixtime_block"),
            @Result(property = "timeCreate", column = "time_create"),
            @Result(property = "timeLicenseStart", column = "time_license_start"),
            @Result(property = "timeLicenseEnd", column = "time_license_end"),
            @Result(property = "timeRequest", column = "time_request")
    })
    List<LicenseEntity> listAll();

}
