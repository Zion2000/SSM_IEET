package com.ieet.dao;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ieet.pojo.Personnel;



public interface AdminDao {

	@Select("select Pid,name,type,team,idname,pword from personnel ")
	@ResultType(Personnel.class)
	public List<Personnel> getAllpersons() ;
	
	@Select("select * from personnel group by team")
	@ResultType(Personnel.class)
	public  List<Personnel> getAllTeams();
	
	@Insert("insert into personnel values (null,#{name},#{type},#{team},#{idname},#{pword})")
	public int insert(Personnel personnel);

	@Select("select * from personnel where Pid=#{Pid} ")
	@ResultType(Personnel.class)
	public Personnel getbyid(int id);

	@Update("update personnel set name = #{name},type = #{type},team = #{team},idname = #{idname},pword = #{pword} where Pid = #{Pid}" )
	public void update(Personnel personnel);

	@Delete("delete from personnel where Pid=#{Pid}  ")
	public void delete(int id);
	
	
	@Delete("delete from personnel where Pid in(${value}) ")
	public void deletemore(String pids);

	@Select("select * from personnel where Pid in(${value}) ")
	public List<Personnel> selectlotbyid(String pids);
	
	@Select("select * from personnel where type=#{type}")
	public List<Personnel> selectbyType(String type);


	public List<Personnel> selectbykeywords(Personnel keywords);
	
		
	public void moreUpdate(List<Personnel> list);

	public void insertlot(List<Personnel> list);

	
	
	
}
