package com.example.weather;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class locationService {
	
	private final locationRespository locationRepo;
	
	@Autowired
	public locationService(locationRespository locationRepo) {
		this.locationRepo = locationRepo;
	}
	
	public  location addNewLocation(location location) throws Exception {
	 List<location> findCity = 	locationRepo.findByCity(location.getCity());
	 
	 if(findCity.size()>0) {
		 throw new Exception("city already exsits in the DB");
	 }
		return locationRepo.save(location);
	}

	public void delete(int id) throws Exception {
		boolean exists=locationRepo.existsById(id);
		if(!exists) {
			throw new Exception("id is not in the database");
		}
		locationRepo.deleteById(id);
	}



}
