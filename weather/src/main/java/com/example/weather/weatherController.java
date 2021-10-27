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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class weatherController {

		public static api api  = new api();
	 
	
		 public addCityToDatabase add = new addCityToDatabase();
	
	public static singleSearchApi singleApi  = new singleSearchApi();
	 
	 private locationService service;
	 
	@Autowired
	public void locationController(locationService service) {
		this.service = service;
	}
	 
@Autowired
locationRespository locationRepo;
	 
	 
	 
	 @CrossOrigin(origins = "https://trusting-kilby-5c1cf3.netlify.app")
	 @JsonSetter("data")
	@RequestMapping("/{city}")
	public  Object getWeatherData(@PathVariable String city) throws Exception {
		Object ex = null;
		System.out.println("trying to get the weather data");
		 
		try {
			
			
		
			
			if(locationRepo.findByCity(city).size()==0) {
			List<location> lists = add.cities(city);
			locationRepo.saveAllAndFlush(lists);
			System.out.println(lists);
			}
			
			 if(locationRepo.findByCity(city).size() >0) {
					int id = locationRepo.findByCity(city).get(0).getId();
					int fave = locationRepo.findByCity(city).get(0).getFavorite();
					Object data = singleApi.apiData(id,city,fave);
					System.out.println(data);
					ex = data;
			 }
			 
		
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return ex;
	}
	 
	 @CrossOrigin(origins = "https://trusting-kilby-5c1cf3.netlify.app")
	 @PostMapping()
	 @RequestMapping("/cities")
	 public void addNewLocation(@RequestBody location location) throws Exception {
		 service.addNewLocation(location);
	 }
	 
	 @CrossOrigin(origins = "https://trusting-kilby-5c1cf3.netlify.app")
	 @RequestMapping("/")
	 public String home()  {
		 return " hello world";
	 }
	 
	 
	 
	 @CrossOrigin(origins = "https://trusting-kilby-5c1cf3.netlify.app")
	 @DeleteMapping()
	 @RequestMapping("/cities/{id}")
	 public void deleteLocation(@PathVariable int id ) throws Exception{
		 service.delete(id);
	 }
	 
	 
	 @CrossOrigin(origins = "https://trusting-kilby-5c1cf3.netlify.app")
	 @RequestMapping( value = "/cities/update" , method = RequestMethod.PUT)
	 public void updateLocation( @RequestBody location location) throws Exception {
		 locationRepo.save(location);
	 }
	 
	 
	 @CrossOrigin(origins = "https://trusting-kilby-5c1cf3.netlify.app")
	 @PostMapping()
	 @RequestMapping("/cities/favorite")
	 public  List<Object> getFavorites() throws Exception {
		 List<Object>locationList = new ArrayList<>(); 
		List <location> list = locationRepo.findAll();
		String city = null;
		String state = " ";
		int id = 0;
		int favorite ;
		for( location x:list){
			int fave = x.getFavorite();
			
			if(fave > 0) {
				id = x.getId();
				city = x.getCity();
				state = x.getState();
				favorite = x.getFavorite();
				Object output = api.apiData(id,city,state,favorite);
				locationList.add(output);
				
			}
			
		}
		System.out.println(locationList);
		return locationList;
	 }
	 
	 	

}
