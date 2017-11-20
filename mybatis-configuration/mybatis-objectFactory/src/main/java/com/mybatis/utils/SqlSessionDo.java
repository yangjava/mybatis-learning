package com.mybatis.utils;

import org.apache.ibatis.session.SqlSession;

public class SqlSessionDo {
	
	public void sqlSession(){
		SqlSession sqlSession=null;
		try {
			sqlSession=SqlSessionFactoryUtils.getSqlSessionFactory("").openSession();
			//DO thing
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			if(sqlSession!=null){
				sqlSession.close();	
			}
		}
	}

}
