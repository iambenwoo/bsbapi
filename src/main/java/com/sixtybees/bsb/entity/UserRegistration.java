package com.sixtybees.bsb.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "user_registration")
@XmlRootElement
public class UserRegistration {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "serial_no")
	private Integer serialNo;
	
	@NotNull
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Column(name = "hash")
	private String hash;
	
	@NotNull
	@Column(name = "status")
	private String status;
	
	
	@CreationTimestamp
	@Column(name = "create_on")
	private Timestamp createOn;
	
	@Column(name = "expiry_on")
	private Timestamp expiryOn;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Timestamp createOn) {
		this.createOn = createOn;
	}

	public Timestamp getExpiryOn() {
		return expiryOn;
	}

	public void setExpiryOn(Timestamp expiryOn) {
		this.expiryOn = expiryOn;
	}
	
}
