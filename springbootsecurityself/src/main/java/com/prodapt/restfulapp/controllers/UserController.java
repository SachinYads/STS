package com.prodapt.restfulapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.restfulapp.models.User;
import com.prodapt.restfulapp.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService userService;
  //allusers
  @GetMapping("/")
  public List<User>getAllUsers(){
	  return this.userService.getAllUser();
  }
  //return single user
  public User getUser(String username) {
	  return this.userService.getUser(username);
  }
}
