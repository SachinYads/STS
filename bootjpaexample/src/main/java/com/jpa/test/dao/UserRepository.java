package com.jpa.test.dao;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpa.test.entities.User;


public interface UserRepository extends CrudRepository<User, Integer>{
	
	public List<User>findByName(String name);
	@Query("select u FROM User u")
	public List<User>getAllUser();
	
	@Query("select u FROM User u WHERE u.name=:n")
	public List<User>getUserByName(@Param("n") String name);


}
