package com.ieet.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ieet.pojo.Personnel;
import com.ieet.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@RequestMapping(value="/admin")
	public String toStudentInfoAdd(Model model) {
		
		List<Personnel> allpersons = adminService.getAllpersons();
	
		model.addAttribute("personlist", allpersons);
		
		return "adminindex";
	}
	
	@RequestMapping(value="/toaddperson")
	public String toaddperson(Model model) {
		
		List<Personnel> allpersons = adminService.getAllpersons();
		model.addAttribute("personlist", allpersons);
		model.addAttribute("Personnel",new Personnel());			
		return "add";
	}
	
	@RequestMapping(value="/addPost",method=RequestMethod.POST)
	public String addPost(Personnel personnel) {
		System.out.println(personnel.getType());
		int i = adminService.save(personnel);
		
		if(i>0) {
		return "redirect:/admin";
		}else {
			return "add";
		}
	}
	
	
	
}
