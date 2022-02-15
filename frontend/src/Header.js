import React,{useContext}  from 'react';
import './Header.css'
import {Link, Route, Switch} from 'react-router-dom';
import Cookies from 'js-cookie';
import AuthContext from './AuthContext';
function Header(props){
		
	const { authToken, setAuthToken } = useContext(AuthContext);

	function LoginLogout(token){
		if(token===null)
			return(
				<Link to="/login" className="link">로그인</Link>
			)
		else
			return(
				<div className="logout" onClick={()=>{Cookies.remove('token'); setAuthToken(null);}}>로그아웃</div>
			)
	}
    return(
        <div className='header-top'>
					<div className="header-left">
						<ul>
							<li>
								{
									LoginLogout(authToken)
								}
							</li>
							<li className="mypage">
								마이페이지▼
								<div className='mypage-detail'>
									<ul>
										<li>주문조회</li>
										<li>장바구니</li>
										<li>관심상품</li>
										<li>회원정보</li>
									</ul>
								</div>
							</li>
							
							<li>
								장바구니
							</li>
						</ul>
					</div>
				
        </div>
    );

}

export default Header