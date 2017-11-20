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
public class MyEnumTypeHandler extends BaseTypeHandler<Sex> {
	
	Logger LOGGER = Logger.getLogger(MyEnumTypeHandler.class);
	

	@Override
	public Sex getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		
		LOGGER.info("使用 MyEnumTypeHandler getNullableResult  "+columnName);
		int id=rs.getInt(columnName);
		return Sex.getSex(id);
	}

	@Override
	public Sex getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		LOGGER.info("使用 MyEnumTypeHandler getNullableResult  "+columnIndex);
		int id=rs.getInt(columnIndex);
		return Sex.getSex(id);
	}

	@Override
	public Sex getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		LOGGER.info("使用 MyEnumTypeHandler getNullableResult  ");
		int id=cs.getInt(columnIndex);
		return Sex.getSex(id);
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Sex parameter,
			JdbcType jdbcType) throws SQLException {
		ps.setInt(i, parameter.getId());
		
	}
}
