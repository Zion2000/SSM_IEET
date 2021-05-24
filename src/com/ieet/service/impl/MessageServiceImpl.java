package com.ieet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ieet.dao.MessageDao;
import com.ieet.pojo.Message;
import com.ieet.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	MessageDao messageDao;
	
	@Override
	public int save(Message message) {
		// TODO Auto-generated method stub
		return messageDao.insert(message);
	}

	@Override
	public List<Message> queryAll() {
		// TODO Auto-generated method stub
		return messageDao.selectAll();
	}

	@Override
	public int delstu(int Mid) {
		// TODO Auto-generated method stub
		return messageDao.delete(Mid);
	}

	@Override
	public List<Message> findpid(int pid) {
		// TODO Auto-generated method stub
		return messageDao.findpid(pid);
	}

}
