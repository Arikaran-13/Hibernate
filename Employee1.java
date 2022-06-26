package com.arikaran.Demohib3;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Employee1 {
	@Override
	public String toString() {
		return "Employee1 [id=" + id + ", name=" + name + ", sal=" + sal + "]";
	}
	@Id
	private int id;
	private String name;
	private int sal;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	

}
