package com.mybatis.service;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.mybatis.dao.UserMapper;
import com.mybatis.model.User;
import com.mybatis.typeHandler.Sex;
import com.mybatis.utils.SqlSessionFactoryUtils;

public class EnumTypeHandlerService {
	
	
	Logger LOGGER = Logger.getLogger(EnumTypeHandlerService.class);

	@Test
	public void testUserDao() {
		SqlSession sqlsession = null;
		try {
			sqlsession = SqlSessionFactoryUtils.getSqlSessionFactory(
					"sqlMapConfig-EnumTypeHandler.xml").openSession();
			// 通过Mapper接口
			UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
			User user = userMapper.selectUserById(1);
			// 	1	yang	杨大	MALE	15110083370	2017-01-01 00:00:00
			LOGGER.info(user.toString());
			LOGGER.info(user.getSex().getName());
			// User [id=null, loginName=wang, name=王五, sex=MALE, mobie=15110083320, createTime=Thu Nov 16 11:56:16 GMT+08:00 2017]
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
					"sqlMapConfig-EnumTypeHandler.xml").openSession();
			// 通过Mapper接口
			UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
			User user=new User();
			user.setLoginName("wang");
			user.setName("王五");
			user.setMobie("15110083320");
			user.setSex(Sex.MALE);
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
