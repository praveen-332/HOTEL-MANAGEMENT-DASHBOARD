package com.telusko.model;
import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Table
public class Hotel {
	@Id
	private Integer hid;
	private String hname;
	private String haddress;
	private String hGSITN;
	
	public Hotel(Integer hid) {
	
		this.hid = hid;
	}
	public Hotel() {
		
	}
	public Integer getHid() {
		return hid;
	}
	public void setHid(Integer hid) {
		this.hid = hid;
	}
	
	
	
	
	
	
	
	
	
	
	
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getHaddress() {
		return haddress;
	}
	public void setHaddress(String haddress) {
		this.haddress = haddress;
	}
	public String gethGSITN() {
		return hGSITN;
	}
	public void sethGSITN(String hGSITN) {
		this.hGSITN = hGSITN;
	}
	
	
	
	
	
	
}
