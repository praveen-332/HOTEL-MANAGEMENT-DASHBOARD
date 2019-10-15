package com.telusko.model;
import javax.persistence.Table;



import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Table
public class Bill {
	@Id
	private Integer billid;
	private String billdate;
	
	
	
	
	public Bill(Integer billid) {
		
		this.billid = billid;
	}
	public Bill() {
		
	}
	public Integer getBillid() {
		return billid;
	}
	public void setBillid(Integer billid) {
		this.billid = billid;
	}

	public String getBilldate() {
		return billdate;
	}
	public void setBilldate(String billdate) {
		this.billdate = billdate;
	}
	
	
}
