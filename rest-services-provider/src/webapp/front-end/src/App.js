
import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';
import './components/SensorTable';
import SensorTable from "./components/SensorTable";
import NavBar from "./components/NavBar";
//Developed by  Hasindu Dahanayake IT18153828
class App extends Component{
render(){
    return(
        <React.Fragment>

      <NavBar></NavBar>
            <div className="h1 text-center">Sensor Details</div>

     <SensorTable></SensorTable>
        </React.Fragment>

    );
}

}

export default App;
