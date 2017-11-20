package com.mybatis.service;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.mybatis.dao.UserMapper;
import com.mybatis.model.User;
import com.mybatis.utils.SqlSessionFactoryUtils;

public class UserService {

	@Test
	public void testUserDao() {
		SqlSession sqlsession = null;
		try {
			sqlsession = SqlSessionFactoryUtils.getSqlSessionFactory("sqlMapConfig.xml")
					.openSession();
			//通过Mapper接口
			UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
			User user = userMapper.selectUserById(1);
			//
			System.out.println(user.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sqlsession.close();
		}
	}

}
