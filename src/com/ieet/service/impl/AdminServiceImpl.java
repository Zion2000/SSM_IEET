package com.ieet.service.impl;

import java.util.ArrayList;
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


	@Override
	public List readExcel(List<Personnel> list) {
		List<Personnel> list2 = adminDao.getAllpersons();		
		List<Personnel> list_false = new ArrayList();
		
		
			for (int i = 0; i < list.size(); i++) {			
				System.out.println("list.get("+i+")-"+list.get(i));
				
				if (list.get(i).getName()==null || list.get(i).getIdname()==null || list.get(i).getPword()==null ) {
					list_false.add(list.get(i));
					continue;
				}
				if (list.get(i).getType()!="教师" && list.get(i).getType()!="审核人员") {
					list_false.add(list.get(i));
					continue;
				}
					for (int j = 0; j < list2.size(); j++) {			
						System.out.println("list2.get("+j+")-"+list2.get(j));
						if(list2.get(j).getIdname().equals(list.get(i).getIdname()))
						{
							System.out.println("ok");					
							list_false.add(list.get(i));//idname重复失败的组									
						}
					}
		}
		

	
		
		for (Personnel personnel : list_false) {
			System.out.println("list_false: "+personnel);
		}

		if (list_false.isEmpty()) {
		System.out.println("OK！id没有重复");
			adminDao.insertlot(list);
			return null;//
		}else {
			System.out.println("NO！id有重复");
			return list_false;
		}
		
	}
}





	



	


	
	



