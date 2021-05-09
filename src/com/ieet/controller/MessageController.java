package com.ieet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ieet.pojo.Message;

import com.ieet.service.MessageService;

@Controller
public class MessageController {
	@Autowired
	MessageService messageService;
	
	
	@RequestMapping(value="/messageAdd",method=RequestMethod.POST)
	public String save(Message message,Model model) {
		if(messageService.save(message)>0) {
			model.addAttribute("message",messageService.queryAll());
			return "messageInfo";
		}else {
			model.addAttribute("msg", "服务器异常：新增学生信息失败");
			return "messageAdd";
		}
	}
	
	@RequestMapping(value="/messageAll",method=RequestMethod.GET)
	public String queryAll(Model model) {
		//students是包含了查询出来的学生信息的集合
		model.addAttribute("messages", messageService.queryAll());
		return "messageInfo";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delstu(int sid ,Model model) {
		messageService.delstu(sid);
		model.addAttribute("messages",messageService.queryAll());
		return "messageInfo";
		
	}

}
