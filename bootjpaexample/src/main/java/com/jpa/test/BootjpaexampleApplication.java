package com.jpa.test;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication

public class BootjpaexampleApplication {

	public static void main(String[] args) {
	ApplicationContext context=	SpringApplication.run(BootjpaexampleApplication.class, args);
	UserRepository userRepository=context.getBean(UserRepository.class);
// For create a user and save in database
	//User user1=new User();
	//user1.setId(1);
	//user1.setName("sachin");
	//user1.setCity("bangalore");
	//user1.setStatus("java");	
	//userRepository.save(user1);
	
//	User user2=new User();
//	user2.setId(2);
//	user2.setName("rishu");
//	user2.setCity("kanpur");
//	user2.setStatus("python");	
	
//	User user3=new User();
//	user3.setId(3);
//	user3.setName("shivam");
//	user3.setCity("farukhabad");
//	user3.setStatus("html");
	
//	User user4=new User();
//	user4.setId(4);
//	user4.setName("gyan");
//	user4.setCity("jaunpur");
//	user4.setStatus("css");	
	
//	User user5=new User();
//	user5.setId(5);
//	user5.setName("vaibhav");
//	user5.setCity("varansi");
//	user5.setStatus("webdevlopment");	
	
//	List<User>users=List.of(user1,  user2, user3, user4, user5);
//	Iterable<User>result=userRepository.saveAll(users);
	
//	result.forEach(useres->{
//		System.out.println(useres);
//	});
//	System.out.println("done");
	
	
	
	// update the user id 5
	
	//Optional<User>optional=userRepository.findById(5);
	
	//User user=optional.get();
	//user.setName("Ankit Tiwari");
	//User result=userRepository.save(user);
	//System.out.println(result);
	
	//how to get the data
	//findById(id)-return optional containing your data
	//Iterable<User> itr=userRepository.findAll();
	 
	//itr.forEach(user->{System.out.println(user);});
	 //Deleting the user element
	// userRepository.deleteById(11);
	// System.out.println("deleted");
	 
	// Iterable<User>allusers=userRepository.findAll();
	// allusers.forEach(user->System.out.println(user));
	// userRepository.deleteAll(allusers);
	
	// List<User>users=userRepository.findByName("sachin");
	// users.forEach(e->System.out.println(e));
	
	//List<User>alluser=userRepository.getAllUser();
	// alluser.forEach(e->{
	//	 System.out.println(e);
	 //});
	List<User>userName=userRepository.getUserByName("sachin");
	userName.forEach(e->{
			 System.out.println(e);
		 });
	
   	}
}
