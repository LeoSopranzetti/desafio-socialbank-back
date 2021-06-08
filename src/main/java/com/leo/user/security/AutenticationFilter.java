package com.leo.user.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.leo.user.models.UserAutentication;
import com.leo.user.repositories.UserAutenticationRepository;

public class AutenticationFilter extends OncePerRequestFilter{
	
	private TokenService tokenService;
	private UserAutenticationRepository userRepository;
	
	public AutenticationFilter(TokenService tokenService, UserAutenticationRepository userRepository) {
		super();
		this.tokenService = tokenService;
		this.userRepository = userRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperarToken(request);
		
		boolean valido = tokenService.isTokenValido(token);
		
		if(valido) {
			autenticarCliente(token);
		}
		
		filterChain.doFilter(request, response);
	}

	private void autenticarCliente(String token) {
		Long idUser = tokenService.getIdUsuario(token);
		UserAutentication user = userRepository.findById(idUser).get();
		UsernamePasswordAuthenticationToken autentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(autentication);
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if( token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;	
		}
		
		return token.substring(7, token.length());
	}

}
