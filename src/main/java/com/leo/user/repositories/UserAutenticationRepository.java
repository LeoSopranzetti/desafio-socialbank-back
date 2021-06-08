package com.leo.user.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leo.user.models.UserAutentication;

@Repository
public interface UserAutenticationRepository extends JpaRepository<UserAutentication, Long>{
	
	Optional<UserAutentication> findByEmail(String email); 
	
}
