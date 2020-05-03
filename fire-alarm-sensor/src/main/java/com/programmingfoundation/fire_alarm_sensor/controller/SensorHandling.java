package com.programmingfoundation.fire_alarm_sensor.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.programmingfoundation.fire_alarm_sensor.model.Sensor;

//Hasindu Dahanayake IT18153828

public class SensorHandling {
	
	//To store sensor details
	private static List<Sensor> sensorList = new ArrayList<Sensor>(); 
	
	//To store the Thread relevant to each sensor
	private static List<Thread> sensorHandlerThreadList = new ArrayList<Thread>();
	//To store the sensorHandler instance which relevant to each sensor
	private static List<SensorHandler> sensorHandlerList = new ArrayList<SensorHandler>();
	
	
	 public static void main( String[] args )
	 
	    {

		 
		       for(;;) {
		    	Client client = ClientBuilder.newClient();
		    	Sensor storeTempSensor = null;
		    	List<Sensor> tempSensorList = new ArrayList<Sensor>(); 
		    	tempSensorList = client
	                      .target("http://localhost:8093/sensorsapi/sensors")
	                      .request(MediaType.APPLICATION_JSON)
	                      .get(Response.class).readEntity(new GenericType<List<Sensor>>() {});
		    	
		    	boolean availability = false;
	    	//This code snnipets will add the newly added sensors in the db to our local sensor list
		    	if(( sensorList.size() < tempSensorList.size() ) ){
		    		for(Sensor tempSensor : tempSensorList) {
		    			availability = false;
		    			for(Sensor tempSensor1 : sensorList) {
		    				if(tempSensor.getId() == tempSensor1.getId()) {
		    					availability = true;
		    				}
		    			}
		    			if(!availability) {//Checking whether if the sensor id is already in our local sensor list if not,
		    			
		    				sensorList.add(tempSensor);//it will be added to our local list
		    				SensorHandler newSensorHandler = new SensorHandler(tempSensor,tempSensor.getId());//New SensorHandler is creating to the sensor
		    				Thread sensorHandlerThread = new Thread(newSensorHandler);//New Thread is creating by passing the runnable instance(SensorHandler instance)
		    				sensorHandlerThread.setName(Integer.toString(tempSensor.getId()));//Naming the thread by sensor name 
		    				sensorHandlerList.add(newSensorHandler);//Adding the sensorHandler to sensorHandler list
		    				sensorHandlerThread.start();//Newly created thread is going to start
		    				 sensorHandlerThreadList.add(sensorHandlerThread);   //Thread is added to the ThreadList
		    				  
		    			}
		    			
		    		}
		    		
		    	}
		    	
		    	else if(sensorList.size() > tempSensorList.size()) {//If our local list is having more sensors than the db (Most probably some sensors have been deleted in the db),then this code snippest will delete that sesnor,sensorHandler,sensorHandlerThread from the three lists
		    		int sensorIndex = -1;

		    		outerloop :for(Sensor tempSensor0 : sensorList) {
		    			sensorIndex ++;
		    			availability = false;
		    			for(Sensor tempSensor1 : tempSensorList) {
		    				if(tempSensor0.getId() == tempSensor1.getId()) {
		    					availability = true;
		    				
		    				}
		    			}
		    			if(!availability) {
		    				int sensorHandlerThreadIndex = -1;
		    				for(Thread tempSensorHandlerThread:sensorHandlerThreadList) {
		    					 sensorHandlerThreadIndex++;
		    					if(tempSensor0.getId() == Integer.parseInt(tempSensorHandlerThread.getName())) {
		    						
		    						
		    					
		    						int sensorHandlerCount = -1;
		    						for(SensorHandler tempSensorHandler : sensorHandlerList) {
		    							sensorHandlerCount ++;
		    							if(tempSensorHandler.getId() == tempSensor0.getId()) {
		    								tempSensorHandler.stop();
		    							}
		    						}
		    						sensorHandlerThreadList.remove( sensorHandlerThreadIndex);
		    					
		    						sensorList.remove(sensorIndex);
		    					   
		    						
		    						System.out.println("++++++++++++++++++++++++++++++++++IMPORTANT3++++++++++++++++++++++++++++++++++++++++++++++++" + sensorHandlerThreadList.size());
		    						break outerloop;
		    					}
		    				}
		    			}
		    		
		    	}
		    		System.out.println("++++++++++++++++++++++++++++++++++IMPORTANT2++++++++++++++++++++++++++++++++++++++++++++++++" + sensorHandlerThreadList.size());
	                    
		     }
		    	
       
	    }
	    }
	
	
	 private static class SensorHandler implements Runnable {//Created an inner class as the sensorHandler class
		 private Sensor sensor;
		 private int id;
		 private boolean exit =false;
		 
		 
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void stop() {//This method will stop the thread [This method is calling in a case of deletion of a sensor in the database]
			exit = true;
			System.out.println("This is true");
		}

		public SensorHandler(Sensor sensor,int id) {
			 this.sensor = sensor;
			 this.id =id;
			 
		 }
		 
		 
		 public void run() {
			 System.out.println("Thread started");
			 while(!exit) {
				 
			  Random rand = new Random(); 
			  Random rand2 = new Random();
			  Client client = ClientBuilder.newClient();	
			 for(;;) {
				 if(!exit) {
			
			  int smokeLevel= rand2.nextInt(11);
			  int co2Level= rand.nextInt(11); 
			
			  sensor.setCoLevel(co2Level);
			  sensor.setSmokeLevel(smokeLevel);
			  try {
			  Response putResponse =client.target("http://localhost:8093/sensorsapi/sensors").request().put(Entity.json(sensor));//Updating the sensor co2Level and smokeLevel for every 10 seconds
			  }catch(Exception e) {
				  System.out.println("Sensor is removed from the database Shutting down the sesnor");
				  
			  }
			  try {
					Thread.sleep(10000);//Thread is sleeping for 10 seconds
				} catch (InterruptedException ie) {
					System.out.println(ie);
				}
				 }else {
					 break;
				 }
			  
			 }
			  
			 }	
			 System.out.println("Thread stopped");
				
			}
	 }
		
	

	
	
	

}
