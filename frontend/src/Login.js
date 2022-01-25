import React  from 'react';
import './Login.css'
import {Link, Route, Switch} from 'react-router-dom';
import axios from 'axios';

function Login(props){
    return(
        <div className='login'>
					<h3>회원 로그인</h3>
					
					<div className="login-box">
						<form onSubmit={(e)=>{
							e.preventDefault();
							axios.post('/login',{
								loginId : e.target.loginId.value,
								password : e.target.password.value
							})
							.then((res)=>{
								if(res.status===200){ //성공
									console.log(res.status,res.data);
								}
								else if(res.status===412){//실패
									console.log(res.status,res.data);
								}
							})
							.catch((err)=>{
								console.log(err);
							})
						}}>
							<div className='id-container'>
								<div className="id">아이디</div>
								<input type="text" name="loginId"/>
							</div>
							<div className='pw-container'>
								<div className="pw">비밀번호</div>
								<input type="password" name="password" />
							</div>
							<div className="login-button">
								<input type='submit' value='Login'/>
							</div>
						</form>
					</div>

					<div className='join-box'>
						<Link to="/join">
							<img src="https://www.boom-style.com/design/kr/login/join_btn.jpg" alt="" />
						</Link>
					</div>
					
        </div>

    );
}

export default Login