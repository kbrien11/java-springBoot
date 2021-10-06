package com.example.weather;
import com.example.weather.api;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class weatherController {

	 public static api api  = new api();
	 
	 public state state = new state();
	 
	 private locationService service;
	 
	@Autowired
	public void locationController(locationService service) {
		this.service = service;
	}
	 
@Autowired
locationRespository locationRepo;
	 
	 
	 
	 @CrossOrigin(origins = "http://localhost:3000")
	 @JsonSetter("data")
	@RequestMapping("/{city}")
	public  Object getWeatherData(@PathVariable String city) {
		Object ex = null;
		System.out.println("trying to get the weather data");
		 
		try {
			
			if(locationRepo.findAll().size()<=0) {
				 List<location> lists = state.cities();
			     locationRepo.saveAllAndFlush(lists);
			}
			else {
				System.out.println(" citites have already been loaded");
			}
		
		     if(locationRepo.findByCity(city).size() >0) {
		    		System.out.println(locationRepo.findByCity(city));
					String location = locationRepo.findByCity(city).get(0).getState();
					Long id = locationRepo.findByCity(city).get(0).getId();
					Object output = api.apiData(id,city,location);
			     
					ex = output;
		     }
		     else {
		    	 System.out.println("somethins is wrong with the DB");
		     }
		
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return ex;
	}
	 
	 @CrossOrigin(origins = "http://localhost:3000")
	 @PostMapping()
	 @RequestMapping("/cities")
	 public void addNewLocation(@RequestBody location location) throws Exception {
		 service.addNewLocation(location);
	 }
	 
	 
	 	
