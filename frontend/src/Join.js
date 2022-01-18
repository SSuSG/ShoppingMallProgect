import React  from 'react';
import './Join.css'
import {Link, Route, Switch} from 'react-router-dom';

function Join(props){
    return(
        <div>
					<div className="join-container">
						<form onSubmit={(e)=>{
							
						}}>
							<p>
								아이디 <img src="https://img.echosting.cafe24.com/skin/base_ko_KR/member/ico_required.gif" alt="" /> <input type="text"/>
							</p>
							<p>
								비밀번호 <img src="https://img.echosting.cafe24.com/skin/base_ko_KR/member/ico_required.gif" alt="" /> <input type="password"  />
							</p>
							<p>
								이름 <img src="https://img.echosting.cafe24.com/skin/base_ko_KR/member/ico_required.gif" alt="" /> <input type="text" />
							</p>
							<p>
								이메일 <img src="https://img.echosting.cafe24.com/skin/base_ko_KR/member/ico_required.gif" alt="" /> <input type="text" />
							</p>
							<p>
								휴대폰 번호 <img src="https://img.echosting.cafe24.com/skin/base_ko_KR/member/ico_required.gif" alt="" /> <input type="text" />
							</p>
							<input type="submit" value="회원가입" />
						</form>
					</div>
        </div>
    );
}
export default Join