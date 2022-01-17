import React, {useEffect, useState} from 'react';
import './App.css';
import Header from './Header';
import Title from './Title';
import Nav from './Nav';
import {Link, Route, Switch} from 'react-router-dom';
import Login from './Login';
function App() {
  const [message, setMessage] = useState("");
  useEffect(() => {
    fetch('/api/hello')
        .then(response => response.text())
        .then(message => {
          setMessage(message);
        });
  },[])
  return (
      <div className="App">
        <Header />
        <Title />
        <Nav />
				<Route exact path="/">
					
				</Route>
				<Route path="/login">
					<Login />
				</Route>
      </div>
  )
}

export default App;
