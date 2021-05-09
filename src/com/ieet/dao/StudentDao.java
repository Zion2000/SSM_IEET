package com.ieet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.ieet.pojo.Student;

public interface StudentDao {
	@Insert("insert into Student (sid,sname,age,course) values(#{sid},#{sname},#{age},#{course})")
	public int insert(Student student);
	
	@Select("Select * from Student")
	@ResultType(Student.class)
	public List<Student> selectAll();
	
	@Delete("delete from Student  where sid = #{sid}" )
	int delete(int sid);
	
}
