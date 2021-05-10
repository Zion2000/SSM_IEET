package com.ieet.service;

import com.ieet.pojo.Admin;
import com.ieet.pojo.Personnel;

public interface LoginService {
	
	public Admin adminLogin(Admin admin);
	
	public Personnel personnelLogin(Personnel personnel);
	
}
