package com.ieet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ieet.pojo.*;
import com.ieet.service.LoginService;
import com.ieet.service.UpLoadService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private UpLoadService uploadService;
	
	
	
	
	@RequestMapping(value="/adminlogin",method=RequestMethod.POST)
	public String rlogin(
			Admin admin,
			Personnel personnel,
			HttpSession session,
			HttpServletRequest request,
			Model model,
			@RequestParam(value="identity",required=false,defaultValue="0") int identity,
			String idname,
			String pword
			) {
	System.out.println("identity "+identity);
	System.out.println("idname "+idname);
	System.out.println("pword "+pword);
	
	if(identity==0) {
		/*	 ErrorPsw Errorid msg*/
		model.addAttribute("Errorid","(必须选择身份)");
	
	}
	if (idname.equals("")) {	
		model.addAttribute("ErrorName","(姓名不能为空)");	
		
	}

	
	if (pword.equals("") || pword.length() == 0) {
		model.addAttribute("Errorid", "(密码不能为空)");
			
	}
		
		//管理
		if(identity==3) {
			Admin amin = loginService.adminLogin(admin);
			if(amin!=null) {
				//login ok
				session.setAttribute("AdminUser", amin);
				System.out.println("AdminUser登陆成功");
				return "forward:/admin/1";
			}else {
				model.addAttribute("msg","(错误账号或密码)");	
				System.out.println("AdminUser登陆失败");
			}
		}
			
		//审核
		if(identity==2 ) {
			 Personnel person2 = loginService.personnelLogin(personnel);
			 if(person2!=null) {
					session.setAttribute("Auditer", person2);
					System.out.println("Auditer登陆成功");
					return "baseInfo";
			 	}else {
			 		model.addAttribute("msg","(错误账号或密码)");
			 		System.out.println("Auditer登陆失败");
			 	}
		}
		//教师
		if(identity==1 ) {
			 Personnel person1 = loginService.personnelLogin(personnel);
			 if(person1!=null) {
					session.setAttribute("Teacher", person1);
					System.out.println("teacher登陆成功");
					//model.addAttribute("blabla",person1.getPid());
					int pid = person1.getPid();
					List<UpLoad> base = uploadService.FindBypid(pid);
					System.out.println(base);
					model.addAttribute("bases",base);
					model.addAttribute("pidds",pid);
					
					return "upload";
		}else{
			model.addAttribute("msg","(错误账号或密码)");
			System.out.println("Teacher登陆失败");
		}

		} 
		return "../login";
	
	
	
	
	
	}
}
	
