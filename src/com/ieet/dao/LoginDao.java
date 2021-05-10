package com.ieet.dao;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.ieet.pojo.Admin;
import com.ieet.pojo.Personnel;

public interface LoginDao {

	
	@Select("select * from admin where  idname=#{idname} and pword=#{pword}")
	@ResultType(Admin.class)
	public Admin adminlogin(Admin admin);
	
	@Select("select * from personnel where  idname=#{idname} and pword=#{pword}")
	@ResultType(Personnel.class)
	public Personnel personlogin(Personnel personnel);
	
	
}
