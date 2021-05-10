package com.ieet.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ieet.pojo.*;
import com.ieet.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/adminlogin",method=RequestMethod.POST)
	public String rlogin(Admin admin,Personnel personnel,HttpSession session,@RequestParam(value="identity",defaultValue="0") int identity) {
	System.out.println("identity "+identity);
	//管理
	if(identity==3) {
		Admin amin = loginService.adminLogin(admin);
		if(amin!=null) {
			//login ok
			session.setAttribute("AdminUser", amin);
			System.out.println("AdminUser登陆成功");
			return "forward:/admin";
		}else {
			System.out.println("AdminUser登陆失败");
		}
	}
		
	//审核
	if(identity==2 ) {
		 Personnel person2 = loginService.personnelLogin(personnel);
		 if(person2!=null) {
				session.setAttribute("Auditer", person2);
				System.out.println("Auditer登陆成功");
				return null;
		 	}else {
		 		System.out.println("Auditer登陆失败");
		 	}
	}
	//教师
	if(identity==1 ) {
		 Personnel person1 = loginService.personnelLogin(personnel);
		 if(person1!=null) {
				session.setAttribute("Teacher", person1);
				System.out.println("teacher登陆成功");
				return null;
	}else{
		System.out.println("Teacher登陆失败");
	}

	}
	
	return "login";
	
	}
}
	
