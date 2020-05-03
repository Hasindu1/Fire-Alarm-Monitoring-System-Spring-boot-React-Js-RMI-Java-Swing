package com.programmingfoundation.restservicesprovider.dto;
//Developed by  Hasindu Dahanayake IT18153828
public class SensorDTO {
	     private int id;
	    private String sensorName;
	    private int floorNumber ;
	    private int roomNumber;
	    private int smokeLevel;
	    private int coLevel;

	    
	    public SensorDTO() {
	    	
	    }

		
		

		public SensorDTO(int id, String sensorName, int floorNumber, int roomNumber, int smokeLevel, int coLevel
				) {
			super();
			this.id = id;
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
		return "SensorDTO{" +
				"id=" + id +
				", sensorName='" + sensorName + '\'' +
				", floorNumber=" + floorNumber +
				", roomNumber=" + roomNumber +
				", smokeLevel=" + smokeLevel +
				", coLevel=" + coLevel +
				'}';
	}
}
