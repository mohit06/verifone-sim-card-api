package com.verifone.simcard.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.verifone.simcard.entity.SimDetails;
import com.verifone.simcard.service.SimService;

@RestController
public class SimCardRestController {
	
	@Autowired
	private SimService simservice;

	@GetMapping("/")
	public ResponseEntity<String> home() {
		return new ResponseEntity<>("This is a message to check that the app is running...",HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody SimDetails simdetails) throws ParseException{
//		Date date = simdetails.getExpiryDate();
//		System.out.println(date+" is date received.");
//		SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");  
//		Date date1=formatter1.parse(date.toString()); 
		//System.out.println(date1.toString());
//		simdetails.setExpiryDate(date1);
//		System.out.println(simdetails.toString());
		
		if(simservice.add(simdetails)) {
			return new ResponseEntity<>("",HttpStatus.CREATED);
		}
		return new ResponseEntity<>("",HttpStatus.NOT_MODIFIED);
		
	}
	
	@GetMapping("/listall")
	public List<SimDetails> listAllSimDetails(){
		return simservice.listAll();
	}
	
	@PutMapping("/:{id}")
	public ResponseEntity<String> updateSimDetails(@PathVariable int id, @RequestBody SimDetails sim) throws ParseException{
		SimDetails simdet = simservice.updateDetails(id,sim);
		if( simdet != null) {
			return new ResponseEntity<String>(simdet.toString(), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("No Record found with SimCardId = "+id, HttpStatus.NOT_MODIFIED);
	}
	
	@DeleteMapping("/:{id}")
	public ResponseEntity<String> deleteRecord(@PathVariable int id){
		if(simservice.deleteDetails(id)) {
			return new ResponseEntity<String>("Record with SimCardId = "+id +" is deleted successfully!!",
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("Record with SimCardId = "+id +" is not found.",
				HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/to-renew")
	public ResponseEntity<ArrayList<SimDetails>> getExpiry() throws ParseException{
		return new ResponseEntity<ArrayList<SimDetails>>(simservice.getExpirySim(),HttpStatus.OK);
	}
}
