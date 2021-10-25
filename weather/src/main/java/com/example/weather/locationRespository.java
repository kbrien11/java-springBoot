package com.example.weather;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface locationRespository extends JpaRepository<location,Integer> {


    List<location> findByCity(String city);

	List<location> save(List<location> lists);

List<Object> saveTo(List<Object> object);

  
}
