package com.example.weather;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class state {

	 public static String cities(String city) throws FileNotFoundException, IOException {
		 List<List<String>> records = new ArrayList<>();
		 String stateCode = null;
		 try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\kbrien\\OneDrive - Capgemini\\Desktop\\weather\\src\\main\\java\\com\\example\\weather\\weatherInfo.csv"))){
		     String line;
		     while ((line = br.readLine()) != null) {
		         String[] values = line.split(",");
		         records.add(Arrays.asList(values));
		     }
		 }
	
		for(List<String> x: records) {
			if(x.get(0).contains(city)) {
				System.out.println(x.get(0));
				System.out.println(x.get(1));
				System.out.println("hello" + city);
				stateCode =x.get(1);
			}
			else {
				System.out.println("City doesnt match");
			}
		}
		return stateCode;
				 
	 }
	 
	
	
}
