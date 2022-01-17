import React  from 'react';
import './Title.css'
import {Link, Route, Switch} from 'react-router-dom';

function Header(props){

    return(
        <div className='title'>
					<Link to='/'>
						<img src="https://www.boom-style.com/SkinImg/top/pc_top_logo_b-t.gif" alt="" />
					</Link>
        </div>
    );

}
export default Header