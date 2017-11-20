package com.mybatis.utils;

import java.io.InputStream;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.mybatis.dao.UserMapper;
import com.mybatis.model.User;

public class SqlSessionFactoryUtils {

	static SqlSessionFactory sqlSessionFactory = null;
	
	private static String url="jdbc:mysql://localhost:3306/mybatis?useSSL=false";
	private static String driver="com.mysql.jdbc.Driver";
	private static String username="root";
	private static String password="root";
	

	/**
	 * 通过XML获取SqlSessionFactory
	 * 
	 * @param resource
	 * @return
	 * @throws Exception
	 */
	public static SqlSessionFactory getSqlSessionFactory(String resource)
			throws Exception {
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;

	}

	public static SqlSessionFactory getSqlSessionFactory() {
		PooledDataSource dataSource = new PooledDataSource();
		dataSource.setDriver(driver);
		dataSource.setUsername(username);
		dataSource.setUrl(url);
		dataSource.setPassword(password);
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development",
				transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.getTypeAliasRegistry().registerAlias("user", User.class);
		configuration.addMapper(UserMapper.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(configuration);
		return sqlSessionFactory;
	}
}
