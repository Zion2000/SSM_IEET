package com.ieet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.ieet.pojo.Message;


public interface MessageDao {
		@Insert("insert into Message (message,name,Pid) values(#{message},#{name},#{Pid})")
		public int insert(Message message);
		
		@Select("Select * from Message")
		@ResultType(Message.class)
		public List<Message> selectAll();
		
		@Delete("delete from Message  where Mid = #{Mid}" )
		int delete(int Mid);

}
