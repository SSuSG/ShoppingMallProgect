import React, {useEffect, useState} from 'react';
import './App.css';
import Header from './Header';
import Title from './Title';
import Goods from './Goods';
import Nav from './Nav';
import {Link, Route, Switch} from 'react-router-dom';
import Login from './Login';
import Join from './Join';
import axios from 'axios';
import { Button } from 'react-bootstrap';
import { AuthProvider } from './AuthContext';
import ProtectedRoute from './ProtectedRoute';
function App() {
  let [loginOrlogout, loginOrlogout변경] = useState('로그인');

  return (
    <AuthProvider>
      <div className="App">
        <Header loginOrlogout={loginOrlogout}/>
        <Title />
        <Nav />
        {/* {console.log(message)} */}
				<ProtectedRoute path="/">
          <Goods />
        </ProtectedRoute>
				<Route path="/login">
          <Login loginOrlogout변경={loginOrlogout변경}/>  
        </Route>
        <Route path="/join" component={Join} />
      </div>
    </AuthProvider>
  )
}

export default App;
