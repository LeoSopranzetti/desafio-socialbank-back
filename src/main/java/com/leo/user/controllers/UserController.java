package com.leo.user.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.user.DTOs.UserDTO;
import com.leo.user.models.User;
import com.leo.user.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/cadastro")
	public ResponseEntity<UserDTO> cadastrarUser(@RequestBody UserDTO userDTO){
		return userService.salvar(userDTO);
	}
	
	@GetMapping("/listar")
	public Page<User> listByPage(Pageable page){
		return userService.findAllWithPage(page);
	}
	
	@GetMapping("/listar/all")
	public List<User> listAll(){
		return userService.findAll();
	}
	
	@GetMapping("/listar/{valor}")
	public List<User> listContainingIgnoring(@PathVariable String valor){
		return userService.findContainingIgnoring(valor);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<User>> byId(@PathVariable Long id) {
		return userService.findById(id);	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		return userService.delete(id);
	}
	
	@PutMapping("/update/{id}")
	@Transactional
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody UserDTO userDTO){
		return userService.update(id, userDTO);
	}
}
