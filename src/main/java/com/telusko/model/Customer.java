package com.telusko.model;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Table
public class Customer {
	@Id
	private Integer cid;
	private String cname;
	private String csex;
	private String cdob;
	private long cphone;
	private String caddress;
	public Customer(Integer cid) {
		this.cid = cid;
	}
	
	public Customer() {
		
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCsex() {
		return csex;
	}

	public void setCsex(String csex) {
		this.csex = csex;
	}

	public String getCdob() {
		return cdob;
	}

	public void setCdob(String cdob) {
		this.cdob = cdob;
	}

	

	public long getCphone() {
		return cphone;
	}

	public void setCphone(long cphone) {
		this.cphone = cphone;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	
	
	
}
