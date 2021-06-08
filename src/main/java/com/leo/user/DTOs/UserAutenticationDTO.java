package com.leo.user.DTOs;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.leo.user.models.UserAutentication;

public class UserAutenticationDTO {

	private Long id;
	private String email;
	private String senha;
	
	public UserAutenticationDTO(UserAutentication user) {}
	
	public UserAutenticationDTO(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsernamePasswordAuthenticationToken converter() {
		
		return new UsernamePasswordAuthenticationToken(email, senha);
	}

	public UserAutentication convertToUser(UserAutenticationDTO userDTO, PasswordEncoder encoder) {
		String senha = encoder.encode(userDTO.getSenha());
		return new UserAutentication(id, email, senha);
	}

	
}
