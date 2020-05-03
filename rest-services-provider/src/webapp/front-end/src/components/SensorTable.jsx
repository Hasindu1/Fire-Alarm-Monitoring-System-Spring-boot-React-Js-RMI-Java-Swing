import React,{Component} from 'react';
import axios from 'axios';


//Developed by  Hasindu Dahanayake IT18153828
class SensorTable extends Component{
    constructor(props){
        super(props);
        this.state = {
            sensorList:[

                ]
    }


        }


  componentDidMount() {
        this.getSesnorDetails();

        this.interval = setInterval(this.getSesnorDetails,40000);//Setting a time interval of 40 seconds to refresh the view

  }
    componentWillUnmount() {
        // Clear the interval right before component unmount
        clearInterval(this.interval);
    }
//Calling the api to get the sensor list
  getSesnorDetails = ()=>{

      axios.get('http://localhost:8093/sensorsapi/sensors').then(res=>
          {
              console.log("This is " + res.data);
              this.setState({ sensorList:res.data});
          }
      );

  }



    render(){
        console.log("This is Main " + this.state.sensorList);
        //Following the concept of conditional rendering ,basically if the smoke level or the co2 level is above 5 then the row of the table will be red nad the status will also be display as Active
        const tableRow = this.state.sensorList.map((sensor)=>{
            if(((sensor.smokeLevel > 5 || sensor.coLevel > 5))){
                return(
                    <tr className="bg-danger">
                        <th scope="row">{sensor.id}</th>
                        <td className="font-weight-bold"> {sensor.sensorName}</td>
                        <td className="font-weight-bold">{sensor.floorNumber}</td>
                        <td className="font-weight-bold">{sensor.roomNumber}</td>
                        <td className="font-weight-bold">{sensor.smokeLevel}</td>
                        <td className="font-weight-bold">{sensor.coLevel}</td>
                        <td className="font-weight-bold">Active</td>


                    </tr>

                )
            }
            //If the co2 lvel or the smoke level is less than or equal to 5 then the table row won't get red nad the status will also be displayed as Not Active
            else {
                return (

                    <tr>
                        <th scope="row">{sensor.id}</th>
                        <td className="font-weight-bold"> {sensor.sensorName}</td>
                        <td className="font-weight-bold">{sensor.floorNumber}</td>
                        <td className="font-weight-bold">{sensor.roomNumber}</td>
                        <td className="font-weight-bold">{sensor.smokeLevel}</td>
                        <td className="font-weight-bold">{sensor.coLevel}</td>
                         <td className="font-weight-bold">Not Active</td>



                    </tr>

                )
            }
        });


        return(
            <div className="container mt-5">
        <table className="table table-hover">
            <thead className="thead-dark">
            <tr>
                <th scope="col">Sensor ID</th>
                <th scope="col">Sensor name</th>
                <th scope="col">Floor number</th>
                <th scope="col">Room number</th>
                <th scope="col">Smoke Level</th>
                <th scope="col">CO<sub>2</sub> Level</th>
                <th scope="col">Status</th>
            </tr>
            </thead>
            <tbody>
            {tableRow}

            </tbody>
        </table>
            </div>
        );


    }

}
export default SensorTable;