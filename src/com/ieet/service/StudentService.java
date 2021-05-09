package com.ieet.service;

import java.util.List;

import com.ieet.pojo.Student;

public interface StudentService {
	public int save(Student student);
	
	public List<Student> queryAll();
	
	public int delstu(int sid);
}
