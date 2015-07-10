package com.mttch.admin.server.mybatis.helpers;

import com.mttch.admin.server.mybatis.entity.LicenseEntity;
import org.apache.ibatis.type.EnumTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubTypeHandler extends EnumTypeHandler<LicenseEntity.Sub> {

    public SubTypeHandler(Class<LicenseEntity.Sub> type) {
        super(LicenseEntity.Sub.class);
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, LicenseEntity.Sub parameter, JdbcType jdbcType) throws SQLException {
        if (jdbcType == null) {
            ps.setString(i, parameter.getDef());
        } else {
            ps.setObject(i, parameter.getDef(), jdbcType.TYPE_CODE);
        }
    }

    @Override
    public LicenseEntity.Sub getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String s = rs.getString(columnName);
        return s == null ? null :
                LicenseEntity.Sub.getByString(s);
    }

    @Override
    public LicenseEntity.Sub getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String s = rs.getString(columnIndex);
        return s == null ? null :
                LicenseEntity.Sub.getByString(s);
    }

    @Override
    public LicenseEntity.Sub getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String s = cs.getString(columnIndex);
        return s == null ? null :
                LicenseEntity.Sub.getByString(s);
    }
}
