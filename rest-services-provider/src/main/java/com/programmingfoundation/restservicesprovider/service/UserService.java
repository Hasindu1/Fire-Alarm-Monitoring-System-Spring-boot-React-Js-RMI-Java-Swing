package com.programmingfoundation.restservicesprovider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.programmingfoundation.restservicesprovider.dto.UserDTO;
//Developed by  Hasindu Dahanayake IT18153828
public interface UserService {
	 public List<UserDTO> findAll();

	

}
