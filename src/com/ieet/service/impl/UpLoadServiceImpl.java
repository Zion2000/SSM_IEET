package com.ieet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ieet.dao.UpLoaddao;
import com.ieet.pojo.UpLoad;
import com.ieet.service.UpLoadService;
@Service
public class UpLoadServiceImpl implements UpLoadService{

	@Autowired
	private UpLoaddao uploaddaos;

	@Override
	public List<UpLoad> FindBypid(int pid) {
		// TODO Auto-generated method stub
		return uploaddaos.FindBypid(pid);
	}

	@Override
	public void InsertFile(UpLoad base) {
		uploaddaos.Insertbalala(base);
		
	}
	


}
