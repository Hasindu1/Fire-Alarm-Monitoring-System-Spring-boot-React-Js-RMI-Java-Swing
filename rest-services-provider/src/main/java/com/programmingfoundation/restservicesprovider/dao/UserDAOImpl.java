package com.programmingfoundation.restservicesprovider.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;


import com.programmingfoundation.restservicesprovider.entity.User;
import org.springframework.stereotype.Repository;
//Developed by  Hasindu Dahanayake IT18153828
@Repository
public class UserDAOImpl implements UserDAO {
  @Autowired
  
 private  EntityManager entityManager;
  
	@Override
	public List<User> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<User> theQuery = currentSession.createQuery("From User",User.class);
		
		List<User> users = theQuery.getResultList();
		
		return users;
	}

}
