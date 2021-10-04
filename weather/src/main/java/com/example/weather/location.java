package com.example.weather;

import java.util.List;

public class location {
	
	
	
	private long id;
	private String city;
	private String state;
	
	public location() {
		
	}
	
	public location(String city , String state) {
		this.city = city;
		this.state = state;
		
	}
	
	public String getCity() {
		return this.city;
		
	}
	
	public String getState() {
		return this.state;
	}
	
	public String setCity() {
		return this.city = city;
	}
	
	public String setState() {
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
