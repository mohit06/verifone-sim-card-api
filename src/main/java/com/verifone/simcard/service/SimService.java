package com.verifone.simcard.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verifone.simcard.entity.SimDetails;
import com.verifone.simcard.repository.SimRepository;

@Service
public class SimService {

	@Autowired
	private SimRepository simrepo;

	public boolean add(SimDetails simdetails) {
		System.out.println("[SERVICE]: " + simdetails.toString());
		if (simrepo.save(simdetails) != null) {
			return true;
		}
		return false;
	}

	public List<SimDetails> listAll() {
		return simrepo.findAll();
	}

	public SimDetails updateDetails(int id, SimDetails simd) throws ParseException {
		Optional<SimDetails> simdet = simrepo.findById(id);
		SimDetails simdetails = simdet.get();
		if (simdetails != null) {

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
		if (simdetails == null)
			return false;
		simrepo.delete(simdetails);
		return true;

	}

	public ArrayList<SimDetails> getExpirySim() throws ParseException {


		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 30);
		Date date = cal.getTime();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String date2 = ft.format(date); 
		System.out.println(ft.parse(date2)+" parsed date");
		ArrayList<SimDetails> sd = simrepo.findAllByExpiryDateLessThanEqual(ft.parse(date2));
		
		return sd;
	}
}
