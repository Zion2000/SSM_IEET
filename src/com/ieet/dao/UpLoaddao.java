package com.ieet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.ieet.pojo.Personnel;
import com.ieet.pojo.UpLoad;

public interface UpLoaddao {
	
	@Select("Select * from base where pid = #{pid} ")
	public List<UpLoad> FindBypid(int pid);

	
	@Insert("insert into base values (null,#{Bstatus},#{name},#{Bdate},#{lujing},#{Pid})")
	public void Insertbalala(UpLoad base);

	
}
