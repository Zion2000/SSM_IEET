package com.ieet.service;

import java.util.Collection;
import java.util.List;
import com.ieet.pojo.Admin;
import com.ieet.pojo.Personnel;


public interface AdminService {
	
	public List<Personnel> getAllpersons();

	public int save(Personnel personnel);
}
