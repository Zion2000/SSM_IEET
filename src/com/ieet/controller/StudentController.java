package com.ieet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ieet.pojo.Student;
import com.ieet.service.StudentService;

@Controller

public class StudentController {
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/studentAdd",method=RequestMethod.POST)
	public String save(Student student,Model model) {
		if(studentService.save(student)>0) {
			model.addAttribute("students",studentService.queryAll());
			return "studentInfo";
		}else {
			model.addAttribute("msg", "服务器异常：新增学生信息失败");
			return "studentAdd";
		}
	}
	
	@RequestMapping(value="/studentAll",method=RequestMethod.GET)
	public String queryAll(Model model) {
		//students是包含了查询出来的学生信息的集合
		model.addAttribute("students", studentService.queryAll());
		return "studentInfo";
	}
	
	//@RequestMapping(value="/delete",method=RequestMethod.GET)
//	public String delstu(int sid ,Model model) {
	//	studentService.delstu(sid);
	//	model.addAttribute("students",studentService.queryAll());
	//	return "studentInfo";
		
	//}

	
}
