package SongGyun.ShoppingMallProject.service;

import SongGyun.ShoppingMallProject.domain.Member;
import SongGyun.ShoppingMallProject.dto.JoinDto;
import SongGyun.ShoppingMallProject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final JavaMailSender emailSender;

    //회원가입
    @Transactional
    public void join(JoinDto joinDto) throws Exception {
        log.info("memberService : join");
        memberRepository.save(joinDto.toEntity());
    }
}
