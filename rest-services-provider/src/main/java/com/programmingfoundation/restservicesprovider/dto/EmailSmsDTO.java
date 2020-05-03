package com.programmingfoundation.restservicesprovider.dto;
//Developed by  Hasindu Dahanayake IT18153828
public class EmailSmsDTO {
    private String email;
    private int contactNumber;
    private String sensorName;
    private int floorNumber ;
    private int roomNumber;
    private int smokeLevel;
    private int coLevel;

    public EmailSmsDTO(){

    }

    public EmailSmsDTO(String email, int contactNumber, String sensorName, int floorNumber, int roomNumber, int smokeLevel, int coLevel) {
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
}
