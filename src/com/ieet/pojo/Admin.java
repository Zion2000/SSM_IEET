package com.ieet.pojo;

import java.util.HashMap;
import java.util.Map;

public class Admin {

	
	private Integer id;
	private String idname;
	private String pword;


	
	public Admin() {
		super();

	}

	public Admin(Integer id, String idname, String pword) {
		super();
		this.id = id;
		this.idname = idname;
		this.pword = pword;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return "admin [id=" + id + ", idname=" + idname + ", pword=" + pword + "]";
	}
	
	
	
	
}
