package com.mttch.admin.server.mybatis.helpers;

import org.apache.ibatis.type.EnumTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BooleanSetTypeHandler extends EnumTypeHandler<BooleanSetEnum> {

    public BooleanSetTypeHandler() {
        super(BooleanSetEnum.class);
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, BooleanSetEnum parameter, JdbcType jdbcType) throws SQLException {
        if (jdbcType == null) {
            ps.setString(i, parameter.getDef());
        } else {
            ps.setObject(i, parameter.getDef(), jdbcType.TYPE_CODE);
        }
    }

    @Override
    public BooleanSetEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String s = rs.getString(columnName);
        return s == null ? null :
                BooleanSetEnum.getByString(s);
    }

    @Override
    public BooleanSetEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String s = rs.getString(columnIndex);
        return s == null ? null :
                BooleanSetEnum.getByString(s);
    }

    @Override
    public BooleanSetEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String s = cs.getString(columnIndex);
        return s == null ? null :
                BooleanSetEnum.getByString(s);
    }
}
