package com.ieet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ieet.dao.BaseDao;
import com.ieet.pojo.Base;
import com.ieet.service.BaseService;

@Service
public class BaseServiceImpl implements BaseService{

	@Autowired
	BaseDao baseDao;
	
	@Override
	public int update_pass(int bid) {
		return baseDao.update_pass(bid);
	}

	@Override
	public int update_fail(int bid) {
		return baseDao.update_fail(bid);
	}
	
	@Override
	public int update_wait(int bid) {
		return baseDao.update_wait(bid);
	}
	@Override
	public List<Base> queryAll() {
		// TODO Auto-generated method stub
		return baseDao.selectAll();
	}
	
	@Override
	public List<Base> queryUnQuery() {
		return baseDao.selectUnQuery();
	}
	
	//查成功
	@Override
	public List<Base> queryPass() {
		return baseDao.selectPass();
	}
	
	@Override
	public List<Base> queryFail() {
		return baseDao.selectFail();
	}

	@Override
	public List<Base> querybyPid(int pid) {
		// TODO Auto-generated method stub
		return baseDao.selectBaseBypid(pid);
	}

	@Override
	public List<Base> querybyMorePid(String pids) {
		// TODO Auto-generated method stub
		return baseDao.selectBaseByMorepid(pids);
	}
	
	


}
