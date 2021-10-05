package com.example.weather;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

//import javax.json.stream.JsonParser;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


 public class api {
	 
	 public static state state = new state();


  @SuppressWarnings("rawtypes")
 public static Object apiData( String city) throws IOException{
	ArrayList<Object> data = new ArrayList<Object>();
	System.out.println(city);
	String ex = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&units=imperial&appid=27b3ec19c7d34c1bcca082098b7a60a7", city);
    URL quote_endpoint = new URL(ex);
	HttpURLConnection connection = (HttpURLConnection) quote_endpoint.openConnection();
    System.out.println(connection);
    connection.setRequestMethod("GET");
    int responseCode = connection.getResponseCode();
    if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String jsonResponseData = new String();
            String readLine = "";
            
            // Append response line by line
            while ((readLine = in.readLine()) != null) {
                jsonResponseData += readLine;
            } 
            
            JSONParser parser = new JSONParser(); 
           
            try {
				JSONObject json = (JSONObject) parser.parse(jsonResponseData);
				data.add(json.get("name"));
				data.add(state.cities(city));
//				looping throug object main to get the temp
				  Object temp= json.get("main");
	
				 data.add((((HashMap) temp).get("temp")));
				 
//				 getting wind data
				  Object wind= json.get("wind" );
				 data.add((((HashMap) wind).get("speed")));
//				looping thru object weather to get the weather type/description
				Object weather = json.get("weather");
				ArrayList<HashMap> descriptionList = new ArrayList<HashMap>();
				descriptionList.addAll((Collection<? extends HashMap>) weather);
				for(int i =0;i<descriptionList.size();i++) {
	                data.add(descriptionList.get(i).get("description"));
	                
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  


        
        }

    		
    		return data;
    }


  
//  public static void main(String[] args) {
//    try{
//    apiData("Dallas");
//    }catch (IOException e){
//      e.printStackTrace();
//    }
//  }
}