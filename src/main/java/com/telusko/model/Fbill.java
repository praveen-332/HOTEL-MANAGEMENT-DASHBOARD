package com.telusko.model;
import javax.persistence.Table;




import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Table
public class Fbill {
	@Id
	private int id;
	
	private int billid;
	private String fbilldate;
	private int totalgross;
	private int tax_gst ;
	private int totalamount;
	public Fbill(int id) {
		super();
		this.id = id;
	}
	
	public Fbill() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBillid() {
		return billid;
	}

	public void setBillid(int billid) {
		this.billid = billid;
	}

	public String getFbilldate() {
		return fbilldate;
	}

	public void setFbilldate(String fbilldate) {
		this.fbilldate = fbilldate;
	}

	public int getTotalgross() {
		return totalgross;
	}

	public void setTotalgross(int totalgross) {
		this.totalgross = totalgross;
	}

	public int getTax_gst() {
		return tax_gst;
	}

	public void setTax_gst(int tax_gst) {
		this.tax_gst = tax_gst;
	}

	public int getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(int totalamount) {
		this.totalamount = totalamount;
	}
	
}
