package com.leo.user.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.leo.user.models.Adress;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long> {
	
	@Query("Select m from Adress m where m.user.id = :id")
	Adress FindByUserId(@Param("id")Long person_id);

}
