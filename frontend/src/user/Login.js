import React  from 'react';
import './Login.css'
import {Link, Route, Switch, Redirect } from 'react-router-dom';
import axios from 'axios';
import { useState, useContext } from 'react';
import Cookies from 'js-cookie';
import AuthContext from '../AuthContext';
import { Spinner } from 'react-bootstrap';
function Login(props){
	
	let[ emailModal, emailModal변경 ] = useState(false);
	let[ spinnerModal, spinnerModal변경] = useState(false);
	const { authToken, setAuthToken } = useContext(AuthContext);
	
	let [userId, userId변경] = useState(null); //이메일 인증 modal에 전달해 줄 state
	let [userPw, userPw변경] = useState(null);
	
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
							spinnerModal변경(true);
							axios.post('/login',{
								loginId : e.target.loginId.value,
								password : e.target.password.value
							})
							.then((res)=>{
								if(res.data===200){ //일반회원
									console.log(res.status,res.data);
									alert('일반회원 로그인 성공');
									props.loginOrlogout변경('로그아웃');
									const authToken = 'fdsojfspodijfosfjho';
									setAuthToken(authToken);
									Cookies.set('token', authToken);
									spinnerModal변경(false);
								}
								else if(res.data===300){ //준회원이면 300 -> 이메일 인증화면 띄워주기
									emailModal변경(true);
									spinnerModal변경(false);
									userId변경(e.target.loginId.value);
									userPw변경(e.target.password.value);
									alert('이메일 인증코드를 입력해주세요');
								} 
								else if(res.data===412){//실패
									console.log(res.status,res.data);
									alert('로그인 실패');
									spinnerModal변경(false);
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
						{spinnerModal===true?<SpinnerModal />:null}
					</div>

					<Link to='/join' className='join-box'>
							<p>회원가입</p>
					</Link>
				
        </div>
				{ emailModal===true? <EmailModal userId={userId} userPw={userPw}  />:null}
			</>

    );
}

function EmailModal(props){
	let [spinner,spinner변경] = useState(false);
	return(
		<div className="emailModal-top">
			<form onSubmit={(e)=>{
				e.preventDefault();
				spinner변경(true);
				axios.post('/join/mail',{
					authenticationKey : e.target.authenticationKey.value,
					loginId : props.userId,
					password : props.userPw,
				})
				.then((res)=>{
					if(res.data===200){ //인증코드가 맞을 경우
						spinner변경(false);
						alert('인증코드가 맞습니다');
					}
					else if(res.data===412){ //인증코드가 틀릴 경우
						spinner변경(false);
						alert('인증코드가 틀렸습니다');
					}
				})
				.catch((err)=>{
					console.log(err)
				})
			}}>
				<p className="emailModal-context">
					이메일 인증번호 
				</p>
				<input type="text" name="authenticationKey"/>
				<input type="submit" value="인증하기" />
			</form>
			{
			spinner===true
			?<Spinner animation="grow" variant="light" />
			:null
			}
		</div>
	);
}

function SpinnerModal(){
	return(
		<div className='spinner-container'>	
			<Spinner animation="border" className="spinner"/>
		</div>
	)
}

export default Login