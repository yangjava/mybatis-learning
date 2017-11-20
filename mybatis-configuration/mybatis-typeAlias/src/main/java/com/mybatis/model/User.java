package com.mybatis.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;
@Alias(value="user")
public class User{
    private Integer id;

    private String loginName;

    private String name;

    private Byte sex;

    private String mobie;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getMobie() {
        return mobie;
    }

    public void setMobie(String mobie) {
        this.mobie = mobie;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", name=" + name
				+ ", sex=" + sex + ", mobie=" + mobie + ", createTime="
				+ createTime + "]";
	}
    
    
}