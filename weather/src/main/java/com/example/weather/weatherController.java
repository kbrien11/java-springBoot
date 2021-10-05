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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class weatherController {

	 public static api api  = new api();
	 
	 public state state = new state();
	 
@Autowired
locationRespository locationRepo;
	 
	 
	 
	 @CrossOrigin(origins = "http://localhost:3000")
	 @JsonSetter("data")
	@RequestMapping("/{city}")
	public  Object getWeatherData(@PathVariable String city) {
		Object ex = null;
		System.out.println("trying to get the weather data");
		 
		try {
		     List<location> lists = state.cities();
		     locationRepo.saveAllAndFlush(lists);
		     if(locationRepo.findByCity(city).size() >0) {
		    		System.out.println(locationRepo.findByCity(city));
					String location = locationRepo.findByCity(city).get(0).getState();
					
					Object output = api.apiData(city,location);
			     
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
	 
//	 @RequestMapping("/cities")
//	 public static List cities() throws FileNotFoundException, IOException {
//		 List<List<String>> records = new ArrayList<>();
//	
//		 try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\kbrien\\OneDrive - Capgemini\\Desktop\\weather\\src\\main\\java\\com\\example\\weather\\weatherInfo.csv"))){
//		     String line;
//		     while ((line = br.readLine()) != null) {
//		         String[] values = line.split(",");
//		         records.add(Arrays.asList(values));
//		     }
//		 }
//	
//		for(List<String> x: records) {
//			System.out.println(x.get(0));
//		}
//		return records;
//				 
//	 }
//	 
//	 
//	 public static void main (String [] args) throws FileNotFoundException, IOException {
//		 cities();
//		 
//	 }
}
