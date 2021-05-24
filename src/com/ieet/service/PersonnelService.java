package com.ieet.service;

import java.util.List;

import com.ieet.pojo.Personnel;




public interface PersonnelService {
	
	public List<Personnel> queryAll();
	
	public int update(Personnel personnel);
	
	public List<Personnel> queryAll1();
	

	public Personnel findBypid(int pid);
}
