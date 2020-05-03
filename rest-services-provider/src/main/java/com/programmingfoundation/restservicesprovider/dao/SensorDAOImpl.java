package com.programmingfoundation.restservicesprovider.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.programmingfoundation.restservicesprovider.dto.SensorDTO;
import com.programmingfoundation.restservicesprovider.entity.Sensor;
//Developed by  Hasindu Dahanayake IT18153828
@Repository
public class SensorDAOImpl implements SensorDAO{
    
	@Autowired
	   private EntityManager entityManager;
		@Override
		public List<Sensor> findAll() {
			Session currentSession = entityManager.unwrap(Session.class);
			
			Query<Sensor> theQuery = currentSession.createQuery("From Sensor",Sensor.class);
			
			List<Sensor> sensors = theQuery.getResultList();
			
			return sensors;
			
		}
		@Override
		public void saveSensor(Sensor sensor) {
			 Session currentSession = entityManager.unwrap(Session.class);

			 currentSession.saveOrUpdate(sensor);
			
		}

		@Override
		public void deleteSensorById(int sensorId) {
			Session currentSession = entityManager.unwrap(Session.class);
			 
			Query theQuery = currentSession.createQuery("delete from Sensor where id=:sensorId");
			theQuery.setParameter("sensorId",sensorId);
			theQuery.executeUpdate();
			
		}
		@Override
		public Sensor getSensor(int theId) {
			 Session currentSession = entityManager.unwrap(Session.class);
			Sensor theSensor = currentSession.get(Sensor.class,theId);
			return theSensor;
		}

}
