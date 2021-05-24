package com.ieet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ieet.dao.PersonnelDao;
import com.ieet.pojo.Personnel;
import com.ieet.service.PersonnelService;
@Service
public class PersonnelServiceImpl implements PersonnelService {
	
	@Autowired
	PersonnelDao personnelDao;
	
	@Override
	public List<Personnel> queryAll() {
		// TODO Auto-generated method stub
		return personnelDao.selectAll();
	}

	@Override
	public int update(Personnel personnel) {
		// TODO Auto-generated method stub
		return personnelDao.update(personnel);
	}

	@Override
	public List<Personnel> queryAll1() {
		// TODO Auto-generated method stub
		return personnelDao.selectAll1();
	}

	@Override
	public Personnel findBypid(int pid) {
		// TODO Auto-generated method stub
		
		return personnelDao.findBypid(pid);
	}





}
