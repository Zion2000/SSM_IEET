package com.ieet.service;

import java.util.Collection;
import java.util.List;
import com.ieet.pojo.Admin;
import com.ieet.pojo.Personnel;


public interface AdminService {
	
	public List<Personnel> getAllpersons();

	public List<Personnel> getAllTeam();
	
	public int save(Personnel personnel);

	public Personnel getpersonbyid(int id);

	public void update(Personnel personnel);

	public void delete(int id);
	
	public void deletemore(String pids);

	public List<Personnel> selectbytype(String type);

	public List<Personnel> selectbykeywords(Personnel keywords);

	public List selectlotbyid(String pids);

	public void MoreUpdate(List<Personnel> ls);

	
}
