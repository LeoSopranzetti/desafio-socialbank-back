package com.leo.user.DTOs;

public class TokenDTO {

	private String token;
	private String tipo;

	public TokenDTO(String token, String string) {
		this.token = token;
		this.tipo = string;
		
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	
	

}
