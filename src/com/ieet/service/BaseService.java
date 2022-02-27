package com.ieet.service;

import java.util.List;

import com.ieet.pojo.Base;

public interface BaseService {
	
	public List<Base> queryAll();
	public List<Base> queryUnQuery();
	
	public List<Base> queryPass();
	public List<Base> queryFail();
	
	
	public int update_pass(int bid); 
	
	public int update_fail(int bid); 
	
	public int update_wait(int bid);
	
}
