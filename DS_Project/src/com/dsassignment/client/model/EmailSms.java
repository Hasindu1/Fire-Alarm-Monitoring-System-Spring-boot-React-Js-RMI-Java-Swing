/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsassignment.client.model;

import com.dsassignment.server.model.Sensor;


/**
 *
 * @author Hasindu Dahanayake IT18153828
 */
public class EmailSms {
     private String email;
    private int contactNumber;
     private String sensorName;
	    private int floorNumber ;
	    private int roomNumber;
	    private int smokeLevel;
	    private int coLevel;
            
            public EmailSms(){
                
            }

    public EmailSms(String email, int contactNumber, String sensorName, int floorNumber, int roomNumber, int smokeLevel, int coLevel) {
        this.email = email;
        this.contactNumber = contactNumber;
        this.sensorName = sensorName;
        this.floorNumber = floorNumber;
        this.roomNumber = roomNumber;
        this.smokeLevel = smokeLevel;
        this.coLevel = coLevel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
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
        return "EmailSms{" + "email=" + email + ", contactNumber=" + contactNumber + ", sensorName=" + sensorName + ", floorNumber=" + floorNumber + ", roomNumber=" + roomNumber + ", smokeLevel=" + smokeLevel + ", coLevel=" + coLevel + '}';
    }
    
    
    
    

   
    
}
