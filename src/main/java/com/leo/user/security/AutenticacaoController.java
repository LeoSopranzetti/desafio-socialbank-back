package com.leo.user.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.user.DTOs.TokenDTO;
import com.leo.user.DTOs.UserAutenticationDTO;
import com.leo.user.DTOs.UserDTO;
import com.leo.user.services.UserAuthService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UserAuthService userAuthService;
	
	@PostMapping
	public ResponseEntity<TokenDTO> autenticar(@RequestBody UserAutenticationDTO userDTO ){
		
			UsernamePasswordAuthenticationToken dadosLogin = userDTO.converter();
			
			try {
				Authentication authentication = authManager.authenticate(dadosLogin);
				String token = tokenService.gerarToken(authentication);
				
				return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
				
			} catch (AuthenticationException e) {
				
				return ResponseEntity.badRequest().build();
				
			}
	}
	
	@PostMapping("/cadastro")
	public ResponseEntity<UserAutenticationDTO> cadastrarUser(@RequestBody UserAutenticationDTO userDTO){
		return userAuthService.save(userDTO);
	}

}
