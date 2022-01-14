package SongGyun.ShoppingMallProject.controller;

import SongGyun.ShoppingMallProject.dto.JoinDto;
import SongGyun.ShoppingMallProject.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //회원가입
    @PostMapping("/join")
    public void createUser(@Valid @RequestBody JoinDto joinDto , BindingResult result) throws Exception {
        if(result.hasErrors()){
            //오류가있으면
            log.info("memberController : createUser오류");
        }
        memberService.join(joinDto);
    }
}
