package com.example.weather;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "weather")
public class location {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private  String state;
	@Column(name = "favorite")
	private int favorite;
	
	public location() {
		
	}
	
	public location(String city , String state) {
		
		this.city = city;
		this.state = state;

	}
public location(long id,String city , String state, int favorite) {
		this.id = id;
		this.city = city;
		this.state = state;
		this.favorite = favorite;
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
	
	public String getCity() {
		return this.city = city;
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
	
	public int getFavorite() {
		return this.favorite = favorite;
	}
	
	public String setState(String state) {
		return this.state = state;
	}
	public int setFavorite() {
		return this.favorite = favorite;
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
