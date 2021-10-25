package com.example.weather;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class addCityToDatabase {

	 public  List<location> cities(String city) throws FileNotFoundException, IOException {
		
		 List<location>locationList = new ArrayList<>();

	
			location loc = new location(
					
					city
				
					
					);
	
			locationList.add(loc);
		
		 
		 
		 System.out.println(locationList);
		 return locationList;	 
	 }
	 
	
	 
	
	
}
