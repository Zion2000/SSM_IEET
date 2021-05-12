package com.ieet.pojo;

public class Personnel {

	private int Pid;
	private String name;
	private String type;
	private String team;
	private String idname;
	private String pword;
	
	
	
	
	
	public Personnel() {
		super();
	}
	public Personnel(int pid, String name, String type, String team, String idname, String pword) {
		super();
		Pid = pid;
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
