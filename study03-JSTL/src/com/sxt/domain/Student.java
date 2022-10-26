package com.sxt.domain;

import java.io.Serializable;

public class Student implements Serializable {
	private String name;
	private String gender;
	private String city;
	private int age;

	public Student() {
		super();
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public Student(String name, String gender, String city, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.city = city;
		this.age = age;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}
}
