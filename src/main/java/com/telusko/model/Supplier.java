package com.telusko.model;
import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Table
public class Supplier {
	@Id
	private Integer sid;
	private String sname;
	private String ssex;
	private String sdob;
	
	//private String sGSTIN;
	
	private long sphone;

	public long getSphone() {
		return sphone;
	}

	public void setSphone(long sphone) {
		this.sphone = sphone;
	}

	private String location;
	
	
	
	public Supplier(Integer sid) {
		
		this.sid = sid;
	}
	
	public Supplier() {
		
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSsex() {
		return ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	public String getSdob() {
		return sdob;
	}

	public void setSdob(String sdob) {
		this.sdob = sdob;
	}

	/*public String getSGSTIN() {
		return sGSTIN;
	}

	public void setSGSTIN(String sGSTIN) {
		this.sGSTIN = sGSTIN;
	}*/

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
}
