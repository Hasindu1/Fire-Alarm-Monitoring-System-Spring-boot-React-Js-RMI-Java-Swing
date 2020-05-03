/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsassignment.servicesimpl;

import com.dsassignment.client.model.EmailSms;
import com.dsassignment.client.model.User;
import com.dsassignment.server.model.Sensor;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.dsassignment.server.services.AlarmService;
import com.sun.xml.internal.ws.api.ha.HaInfo;
import java.util.ArrayList;


import java.util.List;
import java.util.Map;
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
//Service implementations
public class AlarmServiceImpl extends UnicastRemoteObject implements AlarmService{
    //To store Sensor details
    private List<Sensor> sensorList;
    private List<User> userList;
    
    private  Client client ;
    
    //Rest API end point of sensors-api
    private String endPoint;
    
    //Rest API end point of email-sms-api
    private String endPoint2;
    
    //Rest API end point of users-api
    private String endPoint3;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList() {
        List<User> tempUserList = new ArrayList<User>(); 
            tempUserList = client
	                      .target(endPoint3)
	                      .request(MediaType.APPLICATION_JSON)
	                      .get(Response.class).readEntity(new GenericType<List<User>>() {});
           
            this.userList = tempUserList;
           
            
    }
    
   
    
    public List<Sensor> getSensorList() {
        return sensorList;
    }

    public void setSensorList() {
         List<Sensor> tempSensorList = new ArrayList<Sensor>(); 
            tempSensorList = client
	                      .target(endPoint)
	                      .request(MediaType.APPLICATION_JSON)
	                      .get(Response.class).readEntity(new GenericType<List<Sensor>>() {});
           
            this.sensorList = tempSensorList;
            
            
       
    }
    
    
    
    
   
    

    public AlarmServiceImpl() throws RemoteException{
        super();
         this.client = ClientBuilder.newClient();
         this.endPoint ="http://localhost:8093/sensorsapi/sensors";
         this.endPoint2="http://localhost:8093/sms-email-api/sms-emails";
         this.endPoint3="http://localhost:8093/usersapi/users";
    }

    
   
   

   

   

	@Override
	public boolean getloginValidity(String user, String pwd) throws RemoteException {
		   boolean validity = false;
                   //Hashmap will act as the datasource which includes the admin credentials---> Here we can consider that this hashmap got these data from database,since user management
                   //is out of the scope of this system ,here we didn't store those in the db
		   HashMap<String,String> adminDetails = new  HashMap<String, String>();
		   adminDetails.put("admin","admin");
	        
	        try{
                    for (Map.Entry<String, String> admin : adminDetails.entrySet()) {
                       String key = admin.getKey();
                      String value = admin.getValue();
                       if(user.equals(key) && pwd.equals(value)){
	                 validity = true;
	            }
                             }
	           
	            
	           
	            
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        return validity;
	}


    @Override
    public void sendEmailSms() {
       
        

	    	
	    	
	    	for(User tempUser : userList) {
                 
	    		 for(Sensor tempSensor : sensorList) {
	 	        	if((tempSensor.getCoLevel() >5 || tempSensor.getSmokeLevel()>5)) {
                                    EmailSms tempEmailSms = new EmailSms(tempUser.getEmail(),tempUser.getContactNumber(),tempSensor.getSensorName(),tempSensor.getFloorNumber(),tempSensor.getRoomNumber(),tempSensor.getSmokeLevel(),tempSensor.getCoLevel());
                                        System.out.println("Send the email and sms through the rest API ");
	 	        		Response response1 =client.target(endPoint2).request().post(Entity.json(tempEmailSms));;
                                      
	 	        	}
	    		
	    	}
	    	
	       
	        
    }
    }


   
   
    @Override
    public void deleteSensor(int sensorId) throws RemoteException {
       Response deleteResponse =client.target(endPoint+"/"+sensorId).request().delete();
	System.out.println(deleteResponse);
	
    }

    @Override
    public List<Sensor> getSensorDetails() throws RemoteException {
       
            return sensorList;
     
    }

    @Override
    public void addNewSensor(Sensor sensor) throws RemoteException {
       Response postResponse =client.target(endPoint).request().post(Entity.json(sensor));
	
    }

    @Override
    public void updateSensor(Sensor sensor) throws RemoteException {
        Response putResponse =client.target(endPoint).request().put(Entity.json(sensor));
        System.out.println("put respose is " + putResponse);
       
    }
	
    
}
