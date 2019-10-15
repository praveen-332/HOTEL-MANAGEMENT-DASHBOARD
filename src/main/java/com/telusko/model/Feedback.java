package com.telusko.model;

import javax.persistence.Id;




import javax.persistence.Table;
import javax.persistence.Entity;
@Entity
@Table

public class Feedback {
	@Id
	private Integer fid;
	private String givenby;
	private String fdate;
	private String remarks;
	public Feedback(Integer fid) {
		
		this.fid = fid;
	}
	
	public Feedback() {
		
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getGivenby() {
		return givenby;
	}

	public void setGivenby(String givenby) {
		this.givenby = givenby;
	}

	public String getFdate() {
		return fdate;
	}

	public void setFdate(String fdate) {
		this.fdate = fdate;
	}

	

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
