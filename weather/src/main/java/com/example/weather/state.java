package com.example.weather;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.omg.CORBA.portable.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



public class state {


	 public  List<location> cities() throws FileNotFoundException, IOException {
		 List<List<String>> records = new ArrayList<>();
		 List<location>locationList = new ArrayList<>();
//		 long id = 1L;
		 String cityData = " ";
		 String stateData = " ";
		 try (InputStream inputStream = (InputStream) getClass().getResourceAsStream("/weatherInfo.csv");
				    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
				    String contents = reader.lines()
				      .collect(Collectors.joining(System.lineSeparator()));
				    records.add(Arrays.asList(contents));
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
