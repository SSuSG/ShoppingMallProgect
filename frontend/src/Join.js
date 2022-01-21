import React,{useState}  from 'react';
import './Join.css'
import {Link, Route, Switch} from 'react-router-dom';
import axios from 'axios';

function Join(props){

    return(
        <div>
					<div className="join-container">
						<form onSubmit={(e)=>{
							e.preventDefault();
							axios.post('/join',{
								name : e.target.name.value,
								loginId : e.target.loginId.value,
								password : e.target.password.value,
								email : e.target.email.value,
								phoneNum : e.target.phoneNum.value,
							}).then((res)=>{
								console.log(res.status, res.data);
							}).catch((err)=>{
								console.log(err);
							})
						}}>
							<p>
								아이디 <img src="https://img.echosting.cafe24.com/skin/base_ko_KR/member/ico_required.gif" alt="" /> <input type="text" name="loginId"/>
							</p>
							<p>
								비밀번호 <img src="https://img.echosting.cafe24.com/skin/base_ko_KR/member/ico_required.gif" alt="" /> <input type="password" name="password" />
							</p>
							<p>
								이름 <img src="https://img.echosting.cafe24.com/skin/base_ko_KR/member/ico_required.gif" alt="" /> <input type="text" name="name" />
							</p>
							<p>
								이메일 <img src="https://img.echosting.cafe24.com/skin/base_ko_KR/member/ico_required.gif" alt="" /> <input type="text" name="email"/>
							</p>
							<p>
								휴대폰 번호 <img src="https://img.echosting.cafe24.com/skin/base_ko_KR/member/ico_required.gif" alt="" /> <input type="text" name="phoneNum" placeholder='010xxxxxxxx' />
							</p>
							<input type="submit" value="회원가입" />
						</form>
						
					</div>
        </div>
    );
}
export default Join