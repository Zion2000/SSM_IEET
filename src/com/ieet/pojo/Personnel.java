package com.ieet.pojo;

import com.alibaba.excel.annotation.ExcelProperty;

import lombok.Data;

@Data
public class Personnel {
	
	@ExcelProperty(value = "id号", index = 0)
	private int Pid;
	
	@ExcelProperty(value = "名字", index = 1)
	private String name;
	
	
	@ExcelProperty(value = "类型", index = 2)
	private String type;
	
	
	@ExcelProperty(value = "小组", index = 3)
	private String team;
	
	
	@ExcelProperty(value = "账号", index = 4)
	private String idname;	
	
	
	@ExcelProperty(value = "密码", index = 5)
	private String pword;
	
	
	
	
	
	public Personnel() {
		super();
	}
	public Personnel(int pid,String name, String type, String team, String idname, String pword) {
		super();
		this.Pid = pid;
		this.name = name;
		this.type = type;
		this.team = team;
		this.idname = idname;
		this.pword = pword;
	
	}
	public int getPid() {
		return Pid;
	}
	public void setPid(int pid) {
		Pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getIdname() {
		return idname;
	}
	public void setIdname(String idname) {
		this.idname = idname;
	}
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}
	@Override
	public String toString() {
		return "Personnel [Pid=" + Pid + ", name=" + name + ", type=" + type + ", team=" + team + ", idname=" + idname
				+ ", pword=" + pword + "]";
	}
	
	
	
	
	



	
	
	
	
	
}
