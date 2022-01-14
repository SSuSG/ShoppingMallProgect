package SongGyun.ShoppingMallProject.web.login;


import SongGyun.ShoppingMallProject.domain.Member;
import SongGyun.ShoppingMallProject.dto.LoginDto;
import SongGyun.ShoppingMallProject.web.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    //로그인
    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginDto loginDto,
                        BindingResult bindingResult,
                        HttpServletRequest request){
        log.info("loginId : " + loginDto.getLoginId());
        log.info("password : " + loginDto.getPassword());
        if(bindingResult.hasErrors())
            return loginDto.toString();   //다시 로그인화면으로

        log.info("LoginController : 1");
        Member loginUser = loginService.login(loginDto.getLoginId(), loginDto.getPassword());

        if(loginUser == null){
            bindingResult.reject("loginFail" , "아이디 또는 비밀번호가 맞지 않습니다.");
            return "오류";   //다시 로그인화면으로
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER , loginUser);

        return "로그인성공";
        /*
        원래있던 화면으로 돌아갈수있게 해줌
        if(redirectUrl==null)
            return "redirect:/";
        else
            return "redirect:"+redirectUrl;

         */
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        return "로그아웃 성공";
    }

}
