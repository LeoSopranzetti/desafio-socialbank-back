package com.leo.user.DTOs;

import java.time.LocalDate;

import com.leo.user.models.Adress;
import com.leo.user.models.User;
import com.leo.user.repositories.UserRepository;

public class UserDTO {

	private Long id;
	private String name;
	private String email;
	private String phone;
	private LocalDate birthdate;
	private String thumb;
	private Adress adress;
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.phone = user.getPhone();
		this.birthdate = user.getBirthdate();
		this.thumb = user.getThumb();
		this.adress = user.getAdress();
	}
	
	public UserDTO() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	
	public User convertToUser(UserDTO userDTO){	
		return new User(id, name, email, phone, birthdate, thumb, adress);
	}
	
	public User update(Long id, UserRepository userRepository, Adress adress) {
		User user = userRepository.getOne(id);
		
		
		user.setName(this.name);
		user.setEmail(this.email);
		user.setPhone(this.phone);
		user.setBirthdate(this.birthdate);
		user.setThumb(this.thumb);
		user.setAdress(adress);
		
		return user;
}
}
