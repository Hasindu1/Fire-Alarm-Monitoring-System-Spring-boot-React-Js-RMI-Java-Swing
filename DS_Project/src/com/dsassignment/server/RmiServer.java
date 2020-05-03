/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsassignment.server;

import com.dsassignment.server.model.Sensor;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.dsassignment.servicesimpl.AlarmServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Hasindu Dahanayake(IT18153828)
 */
//Rmi server application
public class RmiServer {
    
    
    
    
    public static void main(String[] args) throws RemoteException, InterruptedException {
        Registry registry = LocateRegistry.createRegistry(5097);
        
        //Creation of the remote object
        AlarmServiceImpl alarmServiceImpl = new AlarmServiceImpl();
        
        //binding the remote object
        registry.rebind("alarmServiceImpl", alarmServiceImpl);
        
        for(;;){
            System.out.println("Listening to the REST API");
          //Getting the sensor details from the API for every 15 seconds
          alarmServiceImpl.setSensorList();
          
          //Getting the user details from the rest API for every 15 seconds
          alarmServiceImpl.setUserList();
          
          //Setting the database status flag to to true to give the notification to sms and email apps methods to send the mails and sms to relavant users for every 15 seconds
           alarmServiceImpl.sendEmailSms();
           
           
           //sleep the thread for 15 seconds
            Thread.sleep(15000);
            
        }
        
        
    }
   
}
