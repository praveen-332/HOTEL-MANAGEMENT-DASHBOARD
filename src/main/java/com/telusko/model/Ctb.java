package com.telusko.model;
import javax.persistence.Table;




import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Table
public class Ctb {
	@Id
	private Integer tbid;
	private int cid;
	private int hid;

	private int tnum;
	

	private String tbdate ;
	private String time;
	private String datealloted;
	public String getDatealloted() {
		return datealloted;
	}
	public void setDatealloted(String datealloted) {
		this.datealloted = datealloted;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Ctb(Integer tbid) {
		this.tbid = tbid;
	}
	public Ctb() {
		
	}
	
	public Integer getTbid() {
		return tbid;
	}
	public void setTbid(Integer tbid) {
		this.tbid = tbid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public int getTnum() {
		return tnum;
	}
	public void setTnum(int tnum) {
		this.tnum = tnum;
	}
	public String getTbdate() {
		return tbdate;
	}
	public void setTbdate(String tbdate) {
		this.tbdate = tbdate;
	}

	
}
