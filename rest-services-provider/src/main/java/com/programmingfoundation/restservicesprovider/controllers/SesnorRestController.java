package com.programmingfoundation.restservicesprovider.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.ApplicationScope;

import com.programmingfoundation.restservicesprovider.dao.SensorDAO;
import com.programmingfoundation.restservicesprovider.dto.SensorDTO;
import com.programmingfoundation.restservicesprovider.entity.Sensor;
import com.programmingfoundation.restservicesprovider.service.SensorService;

//Developed by  Hasindu Dahanayake IT18153828
@RestController
@RequestMapping("/sensorsapi")
public class SesnorRestController {
	@Autowired
	private SensorService sensorService;
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/sensors")
	public List<SensorDTO> findAll(){
		return sensorService.findAll();
	}
	
	@PostMapping("/sensors")
	public SensorDTO addSensor(@RequestBody SensorDTO sensorDTO) {
		sensorDTO.setId(0);
		sensorService.saveSensor(sensorDTO);
		
		return sensorDTO;
		
	}
	@GetMapping("/sensors/{sensorId}")
	public SensorDTO getSensor(@PathVariable int sensorId) {
		SensorDTO theSensorDTO = sensorService.getSensor(sensorId);
		if(theSensorDTO == null) {
			throw new RuntimeException("Sensor id not found" + sensorId);
		}
		return theSensorDTO;
		
	}
	@PutMapping("/sensors")
	public SensorDTO updateSensor(@RequestBody SensorDTO theSensorDTO) {
		sensorService.saveSensor(theSensorDTO);
		return theSensorDTO;
	}
	
	@DeleteMapping("/sensors/{sensorId}")
	public String deleteSensor(@PathVariable int sensorId) {
		SensorDTO sensorDTO = sensorService.getSensor(sensorId);
		if(sensorDTO == null) {
			throw new RuntimeException("Senosr id not found -" + sensorId);
		}
		sensorService.deleteSensorById(sensorId);
		return "Deleted sensor id -" + sensorId;
		
		
		
	}
	
	
	
	

}
