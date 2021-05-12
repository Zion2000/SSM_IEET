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
	public List<Personnel> getAllTeam() {
		List<Personnel> list = adminDao.getAllTeams();		
		return list;
	}
	
	@Override
	public int save(Personnel personnel) {
		int insert = adminDao.insert(personnel);
			return insert;
	}

	@Override
	public Personnel getpersonbyid(int id) {		
		 Personnel p = adminDao.getbyid(id);	
		return p;
	}

	@Override
	public void update(Personnel personnel) {
		adminDao.update(personnel);		
	}

	@Override
	public void delete(int id) {
		adminDao.delete(id);		
	}

	@Override
	public void deletemore(String pids) {
		
		adminDao.deletemore(pids);
	}

	@Override
	public List<Personnel> selectbytype(String type) {
		List<Personnel> list = adminDao.selectbyType(type);
		return list;
	}

	@Override
	public List<Personnel> selectbykeywords(Personnel keywords) {
		List<Personnel> list = adminDao.selectbykeywords(keywords);	
		
		return list;
	}

	@Override
	public List selectlotbyid(String pids) {
		List<Personnel> list = adminDao.selectlotbyid(pids);
		return list;
	}
	
	@Override
	public void MoreUpdate(List<Personnel> list) {
		adminDao.moreUpdate(list);
		
	}





	



	


	
	


}
