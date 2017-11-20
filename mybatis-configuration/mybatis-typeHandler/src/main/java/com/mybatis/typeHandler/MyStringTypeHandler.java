package com.mybatis.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.log4j.Logger;

@MappedTypes({ String.class })
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MyStringTypeHandler extends BaseTypeHandler<String> {
	
	Logger LOGGER = Logger.getLogger(MyStringTypeHandler.class);
	
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			String parameter, JdbcType jdbcType) throws SQLException {
		LOGGER.info("使用 MyStringTypeHandler setNonNullParameter");
		ps.setString(i, parameter);
	}

	@Override
	public String getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		
		LOGGER.info("使用 MyStringTypeHandler getNullableResult  "+columnName);
		return rs.getString(columnName);
	}

	@Override
	public String getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		LOGGER.info("使用 MyStringTypeHandler getNullableResult  "+columnIndex);
		return rs.getString(columnIndex);
	}

	@Override
	public String getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		LOGGER.info("使用 MyStringTypeHandler getNullableResult  ");
		return cs.getString(columnIndex);
	}
}
