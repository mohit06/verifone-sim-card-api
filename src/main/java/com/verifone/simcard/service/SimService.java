package com.verifone.simcard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verifone.simcard.entity.SimDetails;
import com.verifone.simcard.repository.SimRepository;

@Service
public class SimService {

	@Autowired
	private SimRepository simrepo;
	
	public boolean add(SimDetails simdetails) {
		System.out.println("[SERVICE]: "+simdetails.toString());
		if(simrepo.save(simdetails) != null) {
			return true;
		}
		return false;
	}
	
	public List<SimDetails> listAll(){
		return simrepo.findAll();
	}
	
	public SimDetails updateDetails(int id, SimDetails simd){
		Optional<SimDetails> simdet = simrepo.findById(id);
		SimDetails simdetails = simdet.get();
		if(simdetails != null) {
			
			simdetails.setExpiryDate(simd.getExpiryDate());
			simdetails.setFullName(simd.getFullName());
			simdetails.setKyc(simd.getKyc());
			simdetails.setMobileNo(simd.getMobileNo());
			simdetails.setStateOfRegistration(simd.getStateOfRegistration());
			simdetails.setStatus(simd.getStatus());
			simdetails.setTeleComProvider(simd.getTeleComProvider());
			simrepo.save(simdetails);
			return simdetails;
		}
		return null;
	}
	
	public boolean deleteDetails(int id) {
		Optional<SimDetails> simdet = simrepo.findById(id);
		SimDetails simdetails = simdet.get();
		if(simdetails == null)
			return false;
		simrepo.delete(simdetails);
		return true;
		
	}
}
