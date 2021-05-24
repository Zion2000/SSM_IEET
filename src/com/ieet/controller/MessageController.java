package com.ieet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ieet.pojo.Message;
import com.ieet.pojo.Personnel;
import com.ieet.service.MessageService;


@Controller
public class MessageController {
	@Autowired
	MessageService messageService;
	
	
	@RequestMapping(value="/messageAdd",method=RequestMethod.POST)
	public String save(Message message,Model model) {
		if(messageService.save(message)>0) {
			model.addAttribute("messages",messageService.queryAll());
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
	
	@RequestMapping(value="/findpid", method=RequestMethod.GET)
	public String findpid(int pid,Model model){
		System.out.println(pid);
		List<Message> message = messageService.findpid(pid);
		System.out.println(message);
		model.addAttribute("messages",message);
		//Message message=null;
		//System.out.println(pid);
		//List<Message> messages = new ArrayList<Message>();
		//message =messageService.findpid(pid);
		//if (message!=null) {
		//	messages.add(message);
		//}else {
		//	messages = messageService.queryAll();
		//}
		//System.out.println(messages);
		//model.addAttribute("messages",messages);
		return "pidmessage";
	}

	@RequestMapping(value="personnelInfo")
	public String a() {
		return null;
	}
	
	@RequestMapping(value="edit_1")
	public String b() {
		return null;
	}
	
	@RequestMapping(value="editdone")
	public String c() {
		return null;
	}
	
	/*@RequestMapping(value="findpid")
	public String d() {
		return null;
	}*/
	/*
	@RequestMapping(value="messageAdd")
	public String e() {
		return null;
	}
	*/
	@RequestMapping(value="messageInfo")
	public String f() {
		return null;
	}
	
	@RequestMapping(value="NewFile")
	public String g() {
		return null;
	}
	
	@RequestMapping(value="pidmessage")
	public String h() {
		return null;
	}


}
