package com.telusko.model;
import javax.persistence.Table;


import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Table
public class Expences {
	@Id
	private Integer expid;
	private int hid;
	private String expamount;
	private String expdate;

	public Expences(Integer expid) {
		
		this.expid = expid;
	}
	public Expences() {
	}
	

	public Integer getExpid() {
		return expid;
	}
	public void setExpid(Integer expid) {
		this.expid = expid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public String getExpamount() {
		return expamount;
	}

	public void setExpamount(String expamount) {
		this.expamount = expamount;
	}

	public String getExpdate() {
		return expdate;
	}

	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}
	
	
	
	
}
