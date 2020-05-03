import React,{Component} from 'react';



//Developed by  Hasindu Dahanayake IT18153828
class NavBar extends Component{
    constructor(props){
        super(props);
    }
    render() {

       return(

            <nav className="navbar navbar-dark bg-dark">
                <a className="navbar-brand "><div className="d-inline "> <i className="fa fa-fire text-danger fa-2x " aria-hidden="true"></i><h3 className="ml-3 d-inline">Fire Alarm Monitor</h3></div></a>

            </nav>


       );
    }

}
export default NavBar;