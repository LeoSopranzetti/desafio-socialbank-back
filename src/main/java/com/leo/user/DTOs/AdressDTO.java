package com.leo.user.DTOs;

import com.leo.user.models.Adress;
import com.leo.user.models.User;

public class AdressDTO {

	private Long id;
	private String postcode;
	private String street;
	private Long number;
	private String district;
	private String city;
	private String state;
	private User user;
	
	public AdressDTO() {}
	
	public AdressDTO(Adress adress) {
		this.id = adress.getId();
		this.postcode = adress.getPostcode();
		this.street = adress.getStreet();
		this.number = adress.getNumber();
		this.district = adress.getDistrict();
		this.city = adress.getCity();
		this.state = adress.getCity();
		this.user = adress.getUser();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
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
	
	
	
	
}
