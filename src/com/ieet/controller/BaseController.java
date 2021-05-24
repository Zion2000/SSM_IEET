package com.ieet.controller;

import java.util.*;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ieet.pojo.Base;
import com.ieet.service.BaseService;

@Controller
public class BaseController {
	
	@Autowired
	BaseService baseService;
	Base base;

	//审核成功捏
	@RequestMapping(value="/pass")
	public String update_pass(int bid,Model model) {
		baseService.update_pass(bid);
		model.addAttribute("bases", baseService.queryPass());
		System.out.println("审核通过个数："+baseService.update_pass(bid));//控制台显示
		return "base_pass";
	}
	
	//审核失败捏
	@RequestMapping(value="/fail")
	public String update_fail(int bid, Model model) {
		baseService.update_fail(bid);
		model.addAttribute("bases", baseService.queryFail());
		System.out.println("审核不通过个数："+baseService.update_fail(bid));//控制台显示
		return "base_fail";
	}
	
	//审核成功页面捏
	@RequestMapping(value="/passWeb")
	public String save_pass(Model model) {
		model.addAttribute("bases", baseService.queryPass());
		return "base_pass";
	}
	
	//审核不成功页面捏
	@RequestMapping(value="/failWeb")
	public String save_fail( Model model) {
		model.addAttribute("bases", baseService.queryFail());
		return "base_fail";
	}
	
	//刷新即可查询捏
	@RequestMapping(value="/baseAll",method=RequestMethod.GET)
	public String queryUnQuery(Model model) {
		model.addAttribute("bases", baseService.queryUnQuery());
		return "baseInfo";
	}
	
	//回退操作
	@RequestMapping(value="/wait")
	public String update_wait(int bid, Model model) {
		baseService.update_wait(bid);
		model.addAttribute("bases", baseService.queryUnQuery());
		return "baseInfo";
	}
	
}
