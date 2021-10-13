package com.example.weather;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class state {


	 public  List<location> cities() throws FileNotFoundException, IOException {
		 List<List<String>> records = new ArrayList<>();
		 List<location>locationList = new ArrayList<>();
//		 long id = 1L;
		 String cityData = null;
		 String stateData = null;
		 try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\kbrien\\OneDrive - Capgemini\\Desktop\\weather\\src\\main\\java\\com\\example\\weather\\weatherInfo.csv"))){
		     String line;
		     while ((line = br.readLine()) != null) {
		         String[] values = line.split(",");
		         records.add(Arrays.asList(values));
		     }
		 }
		
	
		 for(List<String> x: records) {
			cityData = x.get(0);
			stateData = x.get(1);
			
			location loc = new location(
					
					cityData,
					stateData
					
					);
	
			locationList.add(loc);
		
		 }
		 
		 System.out.println(locationList);
		 return locationList;	 
	 }
	 
	
	 
	
	
}
