package com.example.finalpaper.Handler;

import org.apache.ibatis.type.*;

import javax.servlet.annotation.HandlesTypes;
import java.sql.*;

public class MybaitsIntToStringHandler extends  BaseTypeHandler<String> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, Integer.parseInt(parameter));
    }
    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int code = rs.getInt(columnName);
        return String.valueOf(code);
    }
    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int code = rs.getInt(columnIndex);
        return String.valueOf(code);
    }
    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int code = cs.getInt(columnIndex);
        return String.valueOf(code);
    }

}
