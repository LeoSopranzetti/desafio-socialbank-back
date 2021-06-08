package com.leo.user.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leo.user.DTOs.AdressDTO;
import com.leo.user.DTOs.UserDTO;
import com.leo.user.models.Adress;
import com.leo.user.models.User;
import com.leo.user.repositories.AdressRepository;
import com.leo.user.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AdressRepository adressRepository;

	public ResponseEntity<UserDTO> salvar(UserDTO userDTO) {
		
		User user = userDTO.convertToUser(userDTO);
		Adress adress = userDTO.getAdress();
		
		adress.setUser(user);
		adressRepository.save(adress);
		
		user.setAdress(adress);
		userRepository.save(user);
		
		return ResponseEntity.ok().body(new UserDTO(user));
		
	}

	public Page<User> findAllWithPage(Pageable page) {
		return userRepository.findAll(page);
		
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public List<User> findContainingIgnoring(String valor) {
			List<User> users = userRepository.findByNameContainingIgnoreCase(valor);
		return users;
	}

	public ResponseEntity<Optional<User>> findById(Long id) {
		
		Optional<User> user = userRepository.findById(id);
		
		if(user.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(user);
	}

	public ResponseEntity<?> delete(Long id) {
		Optional<User> user = userRepository.findById(id);
		User realUser = userRepository.getOne(id);
		
		if(user.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Adress adress = adressRepository.FindByUserId(id);
		adressRepository.delete(adress);
		userRepository.delete(realUser);
		
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<User> update(Long id, UserDTO userDTO) {
		Optional<User> userOpt = userRepository.findById(id);
		if(userOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Adress adress = userDTO.getAdress();
		
		adress.setId(userDTO.getAdress().getId());
		adress.setStreet(userDTO.getAdress().getStreet());
		adress.setNumber(userDTO.getAdress().getNumber());
		adress.setDistrict(userDTO.getAdress().getDistrict());
		adress.setCity(userDTO.getAdress().getCity());
		adress.setState(userDTO.getAdress().getState());
		adress.setPostcode(userDTO.getAdress().getPostcode());
		adress.setUser(userRepository.getOne(id));
		adressRepository.save(adress);

		User user = userDTO.update(id, userRepository, adress);
		userRepository.save(user);
		
		
		
		
		return ResponseEntity.ok().body(user);
	}

	

	
	

}
