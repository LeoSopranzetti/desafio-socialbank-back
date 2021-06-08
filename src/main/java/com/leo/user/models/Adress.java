package com.leo.user.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Adress {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String postcode;
	private String street;
	private Long number;
	private String district;
	private String city;
	private String state;
	
	@OneToOne(cascade = CascadeType.ALL) @JsonIgnore
	private User user;

	public Adress(Long id, String postcode, String street, Long number, String district, String city, String state,
			User user) {
		this.id = id;
		this.postcode = postcode;
		this.street = street;
		this.number = number;
		this.district = district;
		this.city = city;
		this.state = state;
		this.user = user;
	}
	
	public Adress () {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	
}
