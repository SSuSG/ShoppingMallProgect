import React  from 'react';
import './Login.css'
import Header from './Header'

function Login(props){
    return(
        <div className='login'>
					<h3>회원 로그인</h3>
					<div className="login-box">
						<div>
							<div className="id">아이디</div>
							<input type="text" />
						</div>
						<div>
							<div className="pw">비밀번호</div>
							<input type="text" />
						</div>
					</div>
					<div className="login-button">
						<input type='button' value='Login'/>
					</div>
        </div>

    );
}

export default Login