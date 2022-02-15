import React,{useContext}  from 'react';
import './Header.css'
import {Link, Route, Switch} from 'react-router-dom';
import Cookies from 'js-cookie';
import AuthContext from './AuthContext';
function Header(props){
		
	const { authToken, setAuthToken } = useContext(AuthContext);

    return(
        <div className='header-top'>
					<div className="header-left">
						<ul>
							<li>
								{
								props.loginOrlogout==='로그인'?
								<Link to="/login" className="link">{props.loginOrlogout}</Link>
								:<div className="logout" onClick={()=>{Cookies.remove('token'); setAuthToken(null);}}>{props.loginOrlogout}</div>
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
					<div className="header-right">
						<input type="text" />
					</div>
        </div>
    );

}

export default Header