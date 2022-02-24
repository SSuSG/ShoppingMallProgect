import React,{useState}  from 'react';
import './Join.css'
import {Link, Route, Switch, Redirect, useHistory} from 'react-router-dom';
import axios from 'axios';



function Join(props){
		
		let [loading, loading변경] = useState(false);
		let [loginId, loginId변경] = useState('');
		let [joinSuccess,joinSuccess변경] = useState(true);
		const history = useHistory();
    return(
					<div className="join-container">
						
						<div className="join-title">
							<h2>회원가입</h2>
						</div>
					
						<form onSubmit={(e)=>{
									if(joinSuccess===true){
											e.preventDefault();
											loading변경(true);
											axios.post('/join',{
												name : e.target.name.value,
												loginId : e.target.loginId.value,
												password : e.target.password.value,
												email : e.target.email.value,
												phoneNum : e.target.phoneNum.value,
											}).then((res)=>{
												alert('회원가입 완료!')
												console.log(res.status, res.data);
												loading변경(false);
												history.push('/login');
											}).catch((err)=>{
												console.log(err);
											})
										}
										else{
											alert('아이디가 중복되었습니다. 다시 입력해주세요.');
										}
									}
								}>
								<div className='table-top'>
									<table className="table-content">
										<tr>
											<td>
												아이디 <img src="https://img.echosting.cafe24.com/skin/base_ko_KR/member/ico_required.gif" alt="" />
											</td>
											<td>
												<input type="text" name="loginId" onChange={(e)=>{loginId변경(e.target.value)}}/>
												<div className="overlap-check" onClick={()=>{
													axios.post('/join/'+loginId,{
														loginId : loginId,
													}).then((res)=>{
														if(res.data===200){
															alert('아이디가 사용가능 합니다')
														}
														else if(res.data===412){
															alert('이미 사용중인 아이디 입니다');
															joinSuccess변경(false);
														}
													}).catch((err)=>{
														console.log(err)
													})
												}}>중복확인</div>
											</td>
											
										</tr>
										<tr>
											<td>
												비밀번호 <img src="https://img.echosting.cafe24.com/skin/base_ko_KR/member/ico_required.gif" alt="" />
											</td>
											<td>
												<input type="password" name="password" />
											</td>
										</tr>
										<tr>
											<td>
												이름 <img src="https://img.echosting.cafe24.com/skin/base_ko_KR/member/ico_required.gif" alt="" />
											</td>
											<td>
												<input type="text" name="name" />
											</td>
										</tr>
										<tr>
											<td>
												이메일 <img src="https://img.echosting.cafe24.com/skin/base_ko_KR/member/ico_required.gif" alt="" />
											</td>
											<td>
												<input type="text" name="email"/>
											</td>
										</tr>
										<tr>
											<td>
												휴대폰 번호 <img src="https://img.echosting.cafe24.com/skin/base_ko_KR/member/ico_required.gif" alt="" />
											</td>
											<td>
												<input type="text" name="phoneNum" placeholder='010xxxxxxxx' />
											</td>
										</tr>
									</table>
								</div>
								<div className='join-button-container'>
									<input type="submit" value="회원가입" className="join-button" />
								</div>
							</form>
							<Loading loading={loading} /> 
						
						
{/* 					
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
								loading변경(false);
								emailModal변경(true);
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
							<input type="submit" value="회원가입" onClick={()=>{loading변경(true)}}/>
						</form>
						{ emailModal===true?<EmailModal />:null}
						<Loading loading={loading} /> */}
					</div>
       
    );
}



function Loading(props){

	if(props.loading===true)
		return(
		<div className="loading-container">
			<div className="loading">회원가입 중 입니다...&nbsp;</div>
			
				<div className="spinner-top">
					<div class="spinner-border" role="status">
						<span class="visually-hidden">Loading...</span>
					</div>
				</div>
		</div>
		);
	return null;

}
export default Join