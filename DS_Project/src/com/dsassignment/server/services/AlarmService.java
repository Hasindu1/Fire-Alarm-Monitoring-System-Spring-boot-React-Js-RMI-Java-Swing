/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsassignment.server.services;

import com.dsassignment.server.model.Sensor;
import java.rmi.Remote;
import java.rmi.RemoteException;


import java.util.List;
import javax.ws.rs.client.Client;

/**
 *
 * @author Hasindu Dahanayake(IT18153828)
 */

//Services
public interface AlarmService extends Remote{
    
    //Checks the admin credentilas validity
    public boolean getloginValidity(String user, String pwd) throws RemoteException;
    //Adding a new sensor
    public void addNewSensor(Sensor sensor) throws RemoteException;
    //Updating a new sensor
    public void updateSensor(Sensor sensor) throws RemoteException;
    //Deleting a new sensor
    public void deleteSensor(int sensorId) throws RemoteException;
    //Getting the sensor list
    public List<Sensor> getSensorDetails() throws RemoteException;
    //Setting the db status flag to true to notify sensor app 
    public void sendEmailSms() throws RemoteException;
    
    
    
}
