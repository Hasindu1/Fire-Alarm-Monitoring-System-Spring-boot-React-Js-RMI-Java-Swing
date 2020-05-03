package com.programmingfoundation.restservicesprovider.service;

import java.util.List;

import com.programmingfoundation.restservicesprovider.dto.SensorDTO;
//Developed by  Hasindu Dahanayake IT18153828
public interface SensorService {
	 public List<SensorDTO> findAll();
	    public void saveSensor(SensorDTO sensor);

	    public void deleteSensorById(int sensorId);

	    public SensorDTO getSensor(int theId);

}
