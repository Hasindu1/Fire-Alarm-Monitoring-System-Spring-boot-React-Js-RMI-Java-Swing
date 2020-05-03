package com.programmingfoundation.restservicesprovider.controllers;

import java.util.List;

import com.programmingfoundation.restservicesprovider.dto.EmailSmsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programmingfoundation.restservicesprovider.dto.SensorDTO;
import com.programmingfoundation.restservicesprovider.dto.UserDTO;
import com.programmingfoundation.restservicesprovider.service.SensorService;
import com.programmingfoundation.restservicesprovider.service.UserService;

@RestController
@RequestMapping("/usersapi")
//Developed by  Hasindu Dahanayake IT18153828
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<UserDTO> findAll(){
		return userService.findAll();
	}



}
