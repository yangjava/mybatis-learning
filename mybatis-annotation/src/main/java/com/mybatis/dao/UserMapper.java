package com.mybatis.dao;

import org.apache.ibatis.annotations.Select;

import com.mybatis.model.User;

public interface UserMapper {
    @Select(value="select id, login_name, name, sex, mobie, create_time from user where id = #{id,jdbcType=INTEGER}")
    User selectUserById(Integer id);
}