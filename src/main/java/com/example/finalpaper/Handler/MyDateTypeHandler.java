package com.example.finalpaper.Handler; /**
 * Welcome to https://waylau.com
 */


import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

public class MyDateTypeHandler extends BaseTypeHandler<Date> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType)
            throws SQLException {

        DateFormat df = DateFormat.getDateInstance();
        String dateStr = df.format(parameter);
        ps.setDate(i, java.sql.Date.valueOf(dateStr));
    }

    @Override
    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Date sqlDate = rs.getDate(columnName);
        if (sqlDate != null) {
            return new Date(sqlDate.getTime());
        }
        return null;
    }

    @Override
    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        System.out.println("abc3");
        Date sqlDate = rs.getDate(columnIndex);
        if (sqlDate != null) {
            return new Date(sqlDate.getTime());
        }
        return null;
    }

    @Override
    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        System.out.println("abc4");
        Date sqlDate = cs.getDate(columnIndex);
        if (sqlDate != null) {
            return new Date(sqlDate.getTime());
        }
        return null;
    }

}