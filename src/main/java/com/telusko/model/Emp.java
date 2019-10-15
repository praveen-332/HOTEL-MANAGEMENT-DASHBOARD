package com.telusko.model;



import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Table
public class Emp {
	@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eid;
	//@NotNull
	private String e_firstname;
	//@NotNull
	private String e_lastname;

    protected String birthday;

    protected String strtdate;

	
	
	private String e_sex;
	
	
	 protected String e_email;
	
   protected String ephone;
	
   private String eaddress;
   
   

	public Emp(Integer eid) {
		
		this.eid = eid;
	}
	
	
	

	public Emp() {
		
	}




	public Integer getEid() {
	return eid;
}

public void setEid(Integer eid) {
	this.eid = eid;
}

public String getE_firstname() {
	return e_firstname;
}

public void setE_firstname(String e_firstname) {
	this.e_firstname = e_firstname;
}

public String getE_lastname() {
	return e_lastname;
}

public void setE_lastname(String e_lastname) {
	this.e_lastname = e_lastname;
}

public String getBirthday() {
	return birthday;
}

public void setBirthday(String date) {
	this.birthday = date;
}

public String getStrtdate() {
	return strtdate;
}

public void setStrtdate(String date) {
	this.strtdate = date;
}

public String getE_sex() {
	return e_sex;
}

public void setE_sex(String e_sex) {
	this.e_sex = e_sex;
}

public String getE_email() {
	return e_email;
}

public void setE_email(String e_email) {
	this.e_email = e_email;
}

public String getEphone() {
	return ephone;
}

public void setEphone(String ephone) {
	this.ephone = ephone;
}

public String getEaddress() {
	return eaddress;
}

public void setEaddress(String eaddress) {
	this.eaddress = eaddress;
}

	

}


