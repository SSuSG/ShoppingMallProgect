package SongGyun.ShoppingMallProject;

import SongGyun.ShoppingMallProject.domain.Member;
import SongGyun.ShoppingMallProject.repository.MemberRepository;
import SongGyun.ShoppingMallProject.web.argumentresolver.Login;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HelloController {

    @GetMapping("/api/hello")
    public String hello(){
        return "안녕하세요. 현재 서버시간은 "+new Date() +"입니다. \n";
    }


    @GetMapping("home")
    public Member home(@Login Member loginMember) {
        log.info("loginId : " + loginMember.getLoginId());
        return loginMember;
    }

    /*
    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    // Tip : JWT를 사용하면 UserDetailsService를 호출하지 않기 때문에 @AuthenticationPrincipal 사용 불가능.
    // 왜냐하면 @AuthenticationPrincipal은 UserDetailsService에서 리턴될 때 만들어지기 때문이다.

    // 유저 혹은 매니저 혹은 어드민이 접근 가능
    @GetMapping("user")
    public String user(Authentication authentication) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        System.out.println("principal : "+principal.getMember().getId());
        System.out.println("principal : "+principal.getMember().getLoginId());
        System.out.println("principal : "+principal.getMember().getPassword());

        return "<h1>user</h1>";
    }

    // 매니저 혹은 어드민이 접근 가능
    @GetMapping("manager/reports")
    public String reports() {
        return "<h1>reports</h1>";
    }

    // 어드민이 접근 가능
    @GetMapping("admin/users")
    public List<Member> users(){
        return memberRepository.findAll();
    }

    @PostMapping("join")
    public String join(@RequestBody Member member) {
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        member.setRoles("ROLE_USER");
        memberRepository.save(member);
        return "회원가입완료";
    }
     */
}


