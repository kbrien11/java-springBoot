package com.example.weather;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Location")
public class location {
	
	
	@Id
	private long id;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private  String state;
	
	public location() {
		
	}
	
	public location(String city , String state) {
		
		this.city = city;
		this.state = state;
		
	}
public location(long id,String city , String state) {
		this.id = id;
		this.city = city;
		this.state = state;
		
	}
	
	public String getCity(String city2) {
		return this.city;
		
	}
	
	public long getId() {
		return this.id;
	}
	public long setId() {
		return this.id;
	}
	
	public  String getState() {
		return this.state;
	}
	public  String getState(String city) {
		return this.state;
	}
	
	public String setCity() {
		return this.city = city;
	}
	
	public String setState() {
		return this.state = state;
	}
	
	public String setCity(String city) {
		return this.city = city;
	}
	
	public String setState(String state) {
		return this.state = state;
	}
	@Override
	public String toString() {
		return "location{" +
				"id=" + id +
				", city = '" + city + '\'' +
				", state = '" + state + '\'' +
				'}';
	}

}
