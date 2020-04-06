package com.web.spring.beans;

import com.sun.xml.internal.txw2.annotation.XmlElement;
//used for ajax example not used in app.
@XmlElement
public class User {

	private String firstname;
	private String lastname;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
}
