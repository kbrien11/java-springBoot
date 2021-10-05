package com.example.weather;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface locationRespository extends JpaRepository<location,Long> {


    List<location> findByCity(String city);

	List<location> save(List<location> lists);



  
}