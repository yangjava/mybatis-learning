package com.mybatis.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class SqlSessionDo {
	
	Logger LOGGER = Logger.getLogger(SqlSessionDo.class);
	public void sqlSession(){
		SqlSession sqlSession=null;
		try {
			sqlSession=SqlSessionFactoryUtils.getSqlSessionFactory("").openSession();
			//DO thing
			sqlSession.commit();
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		}finally{
			if(sqlSession!=null){
				sqlSession.close();	
			}
		}
	}

}
