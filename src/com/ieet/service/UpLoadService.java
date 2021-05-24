package com.ieet.service;

import java.util.List;


import com.ieet.pojo.UpLoad;


public interface UpLoadService {
	
	public List<UpLoad> FindBypid(int pid);
	
	public void InsertFile(UpLoad UpLoad);
}
