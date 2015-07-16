package com.mttch.admin.server.mybatis.mapper.admin_corp;

import com.mttch.admin.server.mybatis.entity.AdminUserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AdminUsersDao {

    @Select("select * from admin_corp.admin_users where login = #{login}")
    @ResultMap("listAll-void")
    AdminUserEntity getAdminUser(@Param("login") String login);

    @Insert("insert into admin_corp.admin_users " +
//            "(id, login, password, site, name, surname, email, desc, time, status, access_tech, access_server, access_sipserver_edit, access_iddevice_edit, access_push_edit, access_server_test, access_delete, access_support, access_block, pub) " +
            "values " +
            "(#{id}, #{login}, #{password}, #{site}, #{name}, #{surname}, #{email}, #{desc}, #{time}, #{status}, #{accessTech}, " +
            " #{accessServer}, #{accessSipserverEdit}, #{accessIddeviceEdit}, #{accessPushEdit}, #{accessServerTest}, " +
            " #{accessDelete}, #{accessSupport}, #{accessBlock}, #{pub})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void save(AdminUserEntity user);

    @Delete("delete from admin_corp.admin_users " +
            "where " +
            "login = #{login}")
    void delete(@Param("login") String login);

    @Select("select * from admin_corp.admin_users " +
            "limit #{limit} offset #{offset}")
    @ResultMap("listAll-void")
    List<AdminUserEntity> list(@Param("limit") int limit, @Param("offset") int offset);

    @Select("select count(1) from admin_corp.admin_users")
    int count();

    @Select("select * from admin_corp.admin_users")
    @Results(value = {
            @Result(property = "accessTech", column = "access_tech"),
            @Result(property = "accessServer", column = "access_server"),
            @Result(property = "accessSipserverEdit", column = "access_sipserver_edit"),
            @Result(property = "accessIddeviceEdit", column = "access_iddevice_edit"),
            @Result(property = "accessPushEdit", column = "access_push_edit"),
            @Result(property = "accessServerTest", column = "access_server_test"),
            @Result(property = "accessDelete", column = "access_delete"),
            @Result(property = "accessSupport", column = "access_support"),
            @Result(property = "accessBlock", column = "access_block")})
    List<AdminUserEntity> listAll();

}
