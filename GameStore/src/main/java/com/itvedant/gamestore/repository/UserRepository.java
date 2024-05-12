package com.itvedant.gamestore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.itvedant.gamestore.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@RestResource(exported = false)
	Optional<User> findByEmail(String email);
	
	@RestResource(exported = false)
	<S extends User> S save(S entity);         //S is a object , we can create another object also
}
