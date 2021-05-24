package com.ieet.pojo;

public class Message {
	private int Mid;
	private String message;
	private String name;
	private int Pid;
	private int Bid;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(int mid, String message, String name, int pid, int bid) {
		super();
		Mid = mid;
		this.message = message;
		this.name = name;
		Pid = pid;
		Bid = bid;
	}
	public int getMid() {
		return Mid;
	}
	public void setMid(int mid) {
		Mid = mid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPid() {
		return Pid;
	}
	public void setPid(int pid) {
		Pid = pid;
	}
	public int getBid() {
		return Bid;
	}
	public void setBid(int bid) {
		Bid = bid;
	}


}
