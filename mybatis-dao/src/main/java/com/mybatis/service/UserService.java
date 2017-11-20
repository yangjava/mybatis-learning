package com.mybatis.service;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.mybatis.model.User;
import com.mybatis.utils.SqlSessionFactoryUtils;

public class UserService {

	@Test
	public void testUserDao() {
		SqlSession sqlsession = null;
		try {
			sqlsession = SqlSessionFactoryUtils.getSqlSessionFactory("sqlMapConfig.xml")
					.openSession();
			//namespace + SQL id
			// com.mybatis.dao.UserMapper + selectUserById
			User user = sqlsession.selectOne("com.mybatis.dao.UserMapper.selectUserById",1);
			System.out.println(user.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sqlsession.close();
		}
	}

	@Test
	public void testUserDaoSqlId() {
		SqlSession sqlsession = null;
		try {
			sqlsession = SqlSessionFactoryUtils.getSqlSessionFactory("sqlMapConfig.xml")
					.openSession();
			//namespace + SQL id 如果SQL id 只存在一个,则可以省略namespace
			// com.mybatis.dao.UserMapper + selectUserById
			User user = sqlsession.selectOne("selectUserById",1);
			System.out.println(user.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sqlsession.close();
		}
	}
	
}
