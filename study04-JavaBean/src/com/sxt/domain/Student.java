package com.sxt.domain;

import java.io.Serializable;

public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name = "ÍõÁ¢";
	private String gender;
	public Student() {
		super();
	}
	public Student(String name, String gender) {
		super();
		this.name = name;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", gender=" + gender + "]";
	}
}
