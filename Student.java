package com.arikaran.DemoHibernate;

public class Student {
	
	public Student(String name, int id, String colour) {
		
		this.name = name;
		this.id = id;
		this.colour = colour;
	}
	private String name;
	private int id;
	private String colour;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	
}
