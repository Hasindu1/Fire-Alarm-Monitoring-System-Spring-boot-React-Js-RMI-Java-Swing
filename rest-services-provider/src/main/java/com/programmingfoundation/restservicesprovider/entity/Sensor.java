package com.programmingfoundation.restservicesprovider.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Developed by  Hasindu Dahanayake IT18153828
@Entity
@Table(name="sensor")

public class Sensor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="sensor_name")
	private String sensorName;
	
	@Column(name="floor_number")
	private int floorNumber;
	
	@Column(name="room_number")
	private int roomNumber;
	
	@Column(name="smoke_level")
	private int smokeLevel;
	
	@Column(name="co_level")
	private int coLevel;
	

	public Sensor() {
		
	}
	

	public Sensor(int id, String sensorName, int floorNumber, int roomNumber, int smokeLevel, int coLevel
			) {
		super();
		this.id = id;
		this.sensorName = sensorName;
		this.floorNumber = floorNumber;
		this.roomNumber = roomNumber;
		this.smokeLevel = smokeLevel;
		this.coLevel = coLevel;

	}


	public Sensor(String sensorName, int floorNumber, int roomNumber, int smokeLevel, int coLevel) {
		super();
		this.sensorName = sensorName;
		this.floorNumber = floorNumber;
		this.roomNumber = roomNumber;
		this.smokeLevel = smokeLevel;
		this.coLevel = coLevel;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSensorName() {
		return sensorName;
	}

	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getSmokeLevel() {
		return smokeLevel;
	}

	public void setSmokeLevel(int smokeLevel) {
		this.smokeLevel = smokeLevel;
	}

	public int getCoLevel() {
		return coLevel;
	}

	public void setCoLevel(int coLevel) {
		this.coLevel = coLevel;
	}


	@Override
	public String toString() {
		return "Sensor{" +
				"id=" + id +
				", sensorName='" + sensorName + '\'' +
				", floorNumber=" + floorNumber +
				", roomNumber=" + roomNumber +
				", smokeLevel=" + smokeLevel +
				", coLevel=" + coLevel +
				'}';
	}
}