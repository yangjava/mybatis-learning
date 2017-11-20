package com.mybatis.objectFactory;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.log4j.Logger;

public class MyObjectFactory extends DefaultObjectFactory {
	Logger LOGGER = Logger.getLogger(MyObjectFactory.class);
	private static final long serialVersionUID = 4097859235551405668L;

	public <T> T create(Class<T> type) {
		LOGGER.info("使用MyObjectFactory create");
		return super.create(type);
	}

	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes,
			List<Object> constructorArgs) {
		LOGGER.info("使用MyObjectFactory create");
		return super.create(type, constructorArgTypes, constructorArgs);
	}

	public void setProperties(Properties properties) {
		LOGGER.info("使用MyObjectFactory setProperties");
		super.setProperties(properties);
	}

	public <T> boolean isCollection(Class<T> type) {
		LOGGER.info("使用MyObjectFactory isCollection");
		return super.isCollection(type);
	}
}
