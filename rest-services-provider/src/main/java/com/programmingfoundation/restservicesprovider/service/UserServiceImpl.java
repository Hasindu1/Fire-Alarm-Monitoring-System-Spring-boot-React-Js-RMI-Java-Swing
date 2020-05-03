package com.programmingfoundation.restservicesprovider.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.programmingfoundation.restservicesprovider.dao.UserDAO;
import com.programmingfoundation.restservicesprovider.dto.UserDTO;
import com.programmingfoundation.restservicesprovider.entity.User;
import org.springframework.stereotype.Service;
//Developed by  Hasindu Dahanayake IT18153828
@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserDAO userDAO;
  
	@Override
	@Transactional
	public List<UserDTO> findAll() {
		List<User> userList =userDAO.findAll();
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();
		for(User tempUser: userList) {
			userDTOList.add(new UserDTO(tempUser.getId(),tempUser.getUserName(),tempUser.getPassword(),tempUser.getEmail(),tempUser.getContactNumber()));
		}
		return userDTOList;
		
	}

}
