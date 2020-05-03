package com.programmingfoundation.restservicesprovider.dao;

import java.util.List;

import com.programmingfoundation.restservicesprovider.dto.SensorDTO;
import com.programmingfoundation.restservicesprovider.entity.Sensor;
//Developed by  Hasindu Dahanayake IT18153828
public interface SensorDAO {
	public List<Sensor> findAll();
	
	public void saveSensor(Sensor sensor);


	    public void deleteSensorById(int sensorId);

		public Sensor getSensor(int theId);


}
