package com.ieet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ieet.dao.StudentDao;
import com.ieet.pojo.Student;
import com.ieet.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao studentDao;
	
	@Override
	public int save(Student student) {
		return studentDao.insert(student);
	}

	@Override
	public List<Student> queryAll() {
		// TODO Auto-generated method stub
		return studentDao.selectAll();
	}

	@Override
	public int delstu(int sid) {
		// TODO Auto-generated method stub
		return studentDao.delete(sid);
	}

}
