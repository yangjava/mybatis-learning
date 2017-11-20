package com.mybatis.service;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.mybatis.dao.UserMapper;
import com.mybatis.model.User;
import com.mybatis.utils.SqlSessionFactoryUtils;

public class UserService {

	Logger LOGGER = Logger.getLogger(UserService.class);

	@Test
	public void testUserDao() {
		SqlSession sqlsession = null;
		try {
			sqlsession = SqlSessionFactoryUtils.getSqlSessionFactory(
					"sqlMapConfig.xml").openSession();
			// 通过Mapper接口
			UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
			User user = userMapper.selectUserById(1);
			//
			LOGGER.info(user.toString());
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		} finally {
			sqlsession.close();
		}
	}

	
	@Test
	public void testInsertUserDao() {
		SqlSession sqlsession = null;
		try {
			sqlsession = SqlSessionFactoryUtils.getSqlSessionFactory(
					"sqlMapConfig.xml").openSession();
			// 通过Mapper接口
			UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
			User user=new User();
			user.setLoginName("wang");
			user.setName("王五");
			user.setMobie("15110083320");
			user.setSex(new Byte((byte) 0));
			user.setCreateTime(new Date());
			int i= userMapper.insertUser(user);
			//
			sqlsession.commit();
			LOGGER.info(user.toString()+i);
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		} finally {
			sqlsession.close();
		}
	}
}
