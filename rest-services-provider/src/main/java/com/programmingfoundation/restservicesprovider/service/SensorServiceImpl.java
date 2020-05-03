package com.programmingfoundation.restservicesprovider.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programmingfoundation.restservicesprovider.dao.SensorDAO;
import com.programmingfoundation.restservicesprovider.dto.SensorDTO;
import com.programmingfoundation.restservicesprovider.entity.Sensor;
//Developed by  Hasindu Dahanayake IT18153828
@Service
public class SensorServiceImpl implements SensorService {

	  @Autowired
	    private SensorDAO sensorDAO;

	   @Transactional
	    @Override
	    public List<SensorDTO> findAll() {

	        List<Sensor> sensorList = sensorDAO.findAll();
	        List<SensorDTO> sensorDtoList = new ArrayList<SensorDTO>();
	        for(Sensor sensorTemp: sensorList ) {
	            sensorDtoList.add(new SensorDTO(sensorTemp.getId(),sensorTemp.getSensorName(),sensorTemp.getFloorNumber(),sensorTemp.getRoomNumber(),sensorTemp.getSmokeLevel(),sensorTemp.getCoLevel()));
	        }
	        return sensorDtoList;
	    }
	   
	   @Transactional
@Override
	public void saveSensor(SensorDTO sensorDTO) {

		sensorDAO.saveSensor(new Sensor(sensorDTO.getId(),sensorDTO.getSensorName(),sensorDTO.getFloorNumber(),sensorDTO.getRoomNumber(),sensorDTO.getSmokeLevel(),sensorDTO.getCoLevel()));
		
	}

	   @Transactional
@Override
public void deleteSensorById(int sensorId) {
	sensorDAO.deleteSensorById(sensorId);
	
}
	   @Transactional
@Override
public SensorDTO getSensor(int theId) {
	Sensor theSensor = sensorDAO.getSensor(theId);
	SensorDTO theSensorDTO = new SensorDTO(theSensor.getId(),theSensor.getSensorName(),theSensor.getFloorNumber(),theSensor.getRoomNumber(),theSensor.getSmokeLevel(),theSensor.getCoLevel());
	return theSensorDTO;
	
}

	
}
