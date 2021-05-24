package com.ieet.dao;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ieet.pojo.Base;
public interface BaseDao {
	
	//查全部
	@Select("Select * from Base")
	@ResultType(Base.class)
	public List<Base> selectAll();
	
	//查未审核的
	@Select("Select * from Base where Bstatus = 0")
	@ResultType(Base.class)
	public List<Base> selectUnQuery();
	
	//审核成功后，查询成功的列表
	@Select("Select * from Base where Bstatus=1")
	@ResultType(Base.class)
	public List<Base> selectPass();
	
	//审核失败后，查询失败的列表
	@Select("Select * from Base where Bstatus= -1")
	@ResultType(Base.class)
	public List<Base> selectFail();
	
	//通过
	@Update("update base set Bstatus= 1 where Bid=#{Bid}")
	int update_pass(int bid);
	
	//不通过
	@Update("update base set Bstatus= -1 where Bid=#{Bid}")
	int update_fail(int bid);
	
	//撤回操作
	@Update("update base set Bstatus = 0 where Bid=#{Bid}")
	int update_wait(int bid);
}
