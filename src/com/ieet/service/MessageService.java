package com.ieet.service;

import java.util.List;

import com.ieet.pojo.Message;


public interface MessageService {
	public int save(Message message);
	
	public List<Message> queryAll();
	
	public int delstu(int Mid);
	
	public List<Message> findpid(int pid);

}
