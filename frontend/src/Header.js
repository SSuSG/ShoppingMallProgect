import React  from 'react';
import './Header.css'
import {Link, Route, Switch} from 'react-router-dom';

function Header(props){

    return(
        <div className='header-top'>
					<div className="header-left">
						<ul>
							<li>
								<Link to="/login" className="link">로그인</Link>
							</li>
							<li>
								마이페이지
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