import React, {useEffect, useState} from 'react';
import './App.css';
import Header from './Header';
import Title from './Title';
import Nav from './Nav';
import {Link, Route, Switch} from 'react-router-dom';
import Login from './Login';
import Join from './Join';
import axios from 'axios';

function App() {
<<<<<<< HEAD
  const [message, setMessage] = useState("");
  useEffect(() => {
    axios.get('/admin/members')
        .then((res) => {
          setMessage(res.data);
        });
  },[])
=======
  // const [message, setMessage] = useState("");
  // useEffect(() => {
  //   axios.get('/admin/members')
  //       .then((res) => {
  //         setMessage(res.data);
  //       });
  // },[])
>>>>>>> 40c6a782fb38e2c03f7a35584766451f0959aad6
  return (
      <div className="App">
        
        <Header />
        <Title />
        <Nav />
        {/* {console.log(message)} */}
				<Route exact path="/" />
				<Route path="/login" component={Login} />
        <Route path="/join" component={Join} />
        
      </div>
  )
}

export default App;
