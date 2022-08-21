package com.verifone.simcard.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SimDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	private String simCardNum;
	
	private String mobileNo;
	
	private String status;
	
	private Date expiryDate;
	
	private String stateOfRegistration;
	
	private String kyc;
	
	private String teleComProvider;
	
	private String fullName;

	public String getSimCardNum() {
		return simCardNum;
	}

	public void setSimCardNum(String simCardNum) {
		this.simCardNum = simCardNum;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public Integer getId() {
		return Id;
	}

	

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getStateOfRegistration() {
		return stateOfRegistration;
	}

	public void setStateOfRegistration(String stateOfRegistration) {
		this.stateOfRegistration = stateOfRegistration;
	}

	public String getKyc() {
		return kyc;
	}

	public void setKyc(String kyc) {
		this.kyc = kyc;
	}

	public String getTeleComProvider() {
		return teleComProvider;
	}

	public void setTeleComProvider(String teleComProvider) {
		this.teleComProvider = teleComProvider;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public SimDetails(String simCardNum, String mobileNo, String status, Date expiryDate, String stateOfRegistration,
			String kyc, String teleComProvider, String fullName) {
		super();
		this.simCardNum = simCardNum;
		this.mobileNo = mobileNo;
		this.status = status;
		this.expiryDate = expiryDate;
		this.stateOfRegistration = stateOfRegistration;
		this.kyc = kyc;
		this.teleComProvider = teleComProvider;
		this.fullName = fullName;
	}

	public SimDetails() {
		super();
	}

	@Override
	public String toString() {
		return "SimDetails [SimCardNum=" + simCardNum + ", MobileNo=" + mobileNo + ", Status=" + status
				+ ", ExpiryDate=" + expiryDate + ", StateOfRegistration=" + stateOfRegistration + ", Kyc=" + kyc
				+ ", TeleComProvider=" + teleComProvider + ", FullName=" + fullName + "]";
	}
	
	
	

}
