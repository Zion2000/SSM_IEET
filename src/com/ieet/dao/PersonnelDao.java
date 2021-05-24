package com.ieet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ieet.pojo.Message;
import com.ieet.pojo.Personnel;





public interface PersonnelDao {

	
	@Select("Select * from personnel where team = '0'")
	@ResultType(Personnel.class)
	public List<Personnel> selectAll();
	
	@Update("update personnel set name=#{name},type=#{type},team=#{team},idname=#{idname},pword=#{pword} where pid=#{pid}")
	public int update(Personnel personnel);
	
	@Select("Select * from personnel where team != '0'")
	@ResultType(Personnel.class)
	public List<Personnel> selectAll1();
	
	
	@Select("Select * from personnel where pid = #{pid} ")
	public Personnel findBypid(int pid);

}
