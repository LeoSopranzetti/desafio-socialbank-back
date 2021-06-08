package com.leo.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.leo.user.DTOs.UserAutenticationDTO;
import com.leo.user.models.UserAutentication;
import com.leo.user.repositories.UserAutenticationRepository;

@Service
public class UserAuthService {
	
	@Autowired
	private UserAutenticationRepository repository;
	
	@Autowired
	PasswordEncoder encoder;

	public ResponseEntity<UserAutenticationDTO> save(UserAutenticationDTO userDTO) {
		UserAutentication user = userDTO.convertToUser(userDTO, encoder);
		repository.save(user);	
		return ResponseEntity.ok().body(new UserAutenticationDTO(user));
	}

}
