package com.rj.microservice.citizenservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rj.microservice.citizenservice.entity.Citizen;
import com.rj.microservice.citizenservice.repository.CitizenRepository;

@RestController
@RequestMapping(path = "/citizen")
public class CitizenController {
	
	@Autowired
	CitizenRepository repo;
	
	@RequestMapping(path = "/test")
	public ResponseEntity<String> test() {
		
		return new ResponseEntity<>("Success!", HttpStatus.OK);
	}

	@RequestMapping("/id/{id}")
	public ResponseEntity<List<Citizen>> getCitizenById(@PathVariable Integer id) {
		
		List<Citizen> citizenList = repo.findByVaccinationCenterId(id);
		return new ResponseEntity<>(citizenList, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newCitizen) {
		
		Citizen addedCitizen = repo.save(newCitizen);
		return new ResponseEntity<>(addedCitizen, HttpStatus.OK);
	}
}
