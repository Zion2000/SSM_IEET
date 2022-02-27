package com.ieet.pojo;


public class Base {
	private int bid;
	private String bstatus;
	private String name;
	private String bdate;
	private String reason;
	private String lujing;
	private int pid;
	
	public Base() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Base(int bid, String bstatus, String name, String bdate, String reason, String lujing, int pid) {
		super();
		this.bid = bid;
		this.bstatus = bstatus;
		this.name = name;
		this.bdate = bdate;
		this.reason = reason;
		this.lujing = lujing;
		this.pid = pid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBstatus() {
		return bstatus;
	}

	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getLujing() {
		return lujing;
	}

	public void setLujing(String lujing) {
		this.lujing = lujing;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

}
