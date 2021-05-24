package com.ieet.pojo;

import com.alibaba.excel.annotation.ExcelProperty;

import lombok.Data;

public class UpLoad {
	

	private int Bid;	
	private String Bstatus;
	private String name;	
	private String Bdate;	
	private String lujing;	
	private int Pid;


	
	
	public UpLoad() {
		super();
	}


	public UpLoad(int bid, String bstatus, String name, String bdate, String lujing, int pid) {
		super();
		Bid = bid;
		Bstatus = bstatus;
		this.name = name;
		Bdate = bdate;
		this.lujing = lujing;
		Pid = pid;
	}


	public int getBid() {
		return Bid;
	}


	public void setBid(int bid) {
		Bid = bid;
	}


	public String getBstatus() {
		return Bstatus;
	}


	public void setBstatus(String bstatus) {
		Bstatus = bstatus;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBdate() {
		return Bdate;
	}


	public void setBdate(String bdate) {
		Bdate = bdate;
	}


	public String getLujing() {
		return lujing;
	}


	public void setLujing(String lujing) {
		this.lujing = lujing;
	}


	public int getPid() {
		return Pid;
	}


	public void setPid(int pid) {
		Pid = pid;
	}


	@Override
	public String toString() {
		return "base [Bid=" + Bid + ", Bstatus=" + Bstatus + ", name=" + name + ", Bdate=" + Bdate + ", lujing="
				+ lujing + ", Pid=" + Pid + "]";
	}

	
	
	
}
