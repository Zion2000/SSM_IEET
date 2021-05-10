package com.ieet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ieet.dao.LoginDao;
import com.ieet.pojo.Admin;
import com.ieet.pojo.Personnel;
import com.ieet.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;
	
	@Override
	public Admin adminLogin(Admin admin) {
		Admin a = loginDao.adminlogin(admin);
				if(a!=null) {
					if(admin.getPword().equals(a.getPword())) {
						return a;
					}
				}
				return null;
			
	}

	@Override
	public Personnel personnelLogin(Personnel personnel) {
		// TODO Auto-generated method stub
		
		Personnel p = loginDao.personlogin(personnel);
		if(p!=null) {
			if(p.getPword().equals(personnel.getPword())) {
				return p;
			}
		}
		return null;
	}


}
