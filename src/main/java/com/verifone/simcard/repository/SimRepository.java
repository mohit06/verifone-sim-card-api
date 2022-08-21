package com.verifone.simcard.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verifone.simcard.entity.SimDetails;

@Repository
public interface SimRepository extends JpaRepository<SimDetails, Integer> {

	Optional<SimDetails> findBySimCardNum(String simCardNum);

	 
	  ArrayList<SimDetails> findAllByExpiryDateLessThanEqual(Date expiryDate);
	
}
