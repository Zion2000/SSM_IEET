package com.ieet.pojo;

public class Student {
	private String sid;
	private String sname;
	private int age;
	private String course;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String sid, String sname, int age, String course) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.age = age;
		this.course = course;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
}
