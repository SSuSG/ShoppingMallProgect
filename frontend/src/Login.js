import React  from 'react';
import './Login.css'
import {Link, Route, Switch, Redirect } from 'react-router-dom';
import axios from 'axios';
import { useState, useContext } from 'react';
import Cookies from 'js-cookie';
import AuthContext from './AuthContext';

function Login(props){
	
	let[emailModal, emailModal변경] = useState(true);

	const { authToken, setAuthToken } = useContext(AuthContext);
	
	if (authToken){
		props.loginOrlogout변경('로그아웃');
		return <Redirect to="/" />;
	}

    return(
			<>
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
								if(res.status===200){ //일반회원
									console.log(res.status,res.data);
									alert('일반회원 로그인 성공');
									props.loginOrlogout변경('로그아웃');
									const authToken = 'fdsojfspodijfosfjho';
									setAuthToken(authToken);
									Cookies.set('token', authToken);
								}
								else if(res.status===300){ //준회원이면 300 -> 이메일 인증화면 띄워주기
									emailModal변경(true);
									alert('이메일 인증코드를 입력해주세요');
								} 
								else if(res.status===412){//실패
									console.log(res.status,res.data);
									alert('로그인 실패');
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
				{ emailModal===true?<EmailModal />:null}
			</>

    );
}

function EmailModal(props){

	return(
		<div className="emailModal-top">
			<form>
				<p className="emailModal-context">
					이메일 인증번호 
				</p>
				<input type="text" name="code"/>
				<input type="submit" value="인증하기" />
			</form>
		</div>
	);
}

export default Login