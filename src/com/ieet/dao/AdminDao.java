package com.ieet.dao;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import com.ieet.pojo.Personnel;



public interface AdminDao {

	@Select("select * from personnel ")
	@ResultType(Personnel.class)
	public List<Personnel> getAllpersons() ;

	
	@Insert("insert into personnel values (null,#{name},#{type},#{team},#{idname},#{pword})")
	public int insert(Personnel personnel);
	
	
}
