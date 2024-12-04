package org.example.demo_1203.entity;


import lombok.Data;

@Data

public class User {
	private int id;
	private String usname;
	private String psword;
	private String age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsname() {
		return usname;
	}
	public void setUsname(String usname) {
		this.usname = usname;
	}
	public String getPsword() {
		return psword;
	}
	public void setPsword(String psword) {
		this.psword = psword;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(int id, String usname, String psword, String age) {
		this.id = id;
		this.usname = usname;
		this.psword = psword;
		this.age = age;
	}
}
