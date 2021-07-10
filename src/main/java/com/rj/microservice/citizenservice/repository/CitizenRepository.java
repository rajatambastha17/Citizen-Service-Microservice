package com.rj.microservice.citizenservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rj.microservice.citizenservice.entity.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
	
	public List<Citizen> findByVaccinationCenterId(Integer id);
}
