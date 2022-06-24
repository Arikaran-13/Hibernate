package com.arikaran.Demohib3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity // marking this class as asn entity
@Table(name="Alien_table") // changes the table name from class name to "Alien_table"
public class Alien {
	@Id//primary key
	private int aid;
	
	//@Transient // this aname coloumn will not be persisted or saved inside database;
	private AlienName aname;

  
	@Column(name="Alien_colour")//changes the cloumn name colour to "Alien_colour"
	private String colour;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public AlienName getAname() {
		return aname;
	}
	public void setAname(AlienName aname) {
		this.aname = aname;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	
@Override
public String toString() {
	
	return aname+" "+aid+" "+colour;
}
}
