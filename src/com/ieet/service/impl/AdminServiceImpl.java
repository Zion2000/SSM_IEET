package com.ieet.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ieet.dao.AdminDao;
import com.ieet.dao.LoginDao;
import com.ieet.pojo.Admin;
import com.ieet.pojo.Personnel;
import com.ieet.service.AdminService;
import com.ieet.service.LoginService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;

	@Override
	public List<Personnel> getAllpersons() {
		List<Personnel> list = adminDao.getAllpersons();
			return list;
	}

	@Override
	public int save(Personnel personnel) {
		System.out.println("test1: "+personnel.getName()+personnel.getTeam()+personnel.getType()+personnel.getIdname()+personnel.getPword());
		int insert = adminDao.insert(personnel);
		System.out.println("test2: ");		
			return insert;
		
		
	
	}

	


	
	


}
