package SongGyun.ShoppingMallProject.service;

import SongGyun.ShoppingMallProject.domain.Member;
import SongGyun.ShoppingMallProject.dto.*;
import SongGyun.ShoppingMallProject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    //이메일 인증
    @Transactional
    public boolean IsEqualAuthenticationKey(Long id, String authenticationKey) {
        log.info("memberService : IsEqualAuthenticationKey");
        Member member = memberRepository.findById(id).get();
        if(member.getAuthenticationKey().equals(authenticationKey)){
            member.updateRoleTypeForJoin();
            return true;
        }
        return false;
    }

    //아이디 중복체크
    public boolean checkLoginIdDuplicate(String loginId) {
        log.info("memberService : checkLoginIdDuplicate");
        //true -> 아이디중복 , false -> 아이디중복 없음
        return memberRepository.existsByLoginId(loginId);
    }

    //ID찾기
    public String findLoginId(FindLoginIdDto findLoginIdDto) {
        log.info("memberService : findLoginId");
        Optional<Member> findUser = memberRepository.findByNameAndEmail(findLoginIdDto.getName(), findLoginIdDto.getEmail());
        if(findUser.isPresent()){
            return findUser.get().getLoginId();
        }else{ //존재하지 않으면
            throw new IllegalStateException("일치하는 회원의 아이디가 없습니다.");
        }
    }

    //PW찾기
    public String findPassword(FindPasswordDto findPasswordDto) {
        log.info("memberService : findPassword");
        Optional<Member> findUser = memberRepository.findByNameAndEmailAndLoginId(
                findPasswordDto.getName(), findPasswordDto.getEmail(), findPasswordDto.getLoginId());
        if(findUser.isPresent()){
            return findUser.get().getPassword();
        }else{ //존재하지 않으면
            throw new IllegalStateException("일치하는 회원의 비밀번호를 찾을수없습니다.");
        }
    }

    //모든회원조회
    public List<MemberDto> findAllMembers(){
        log.info("memberService : findAllMembers");
        List<MemberDto> memberDtoList =
                memberRepository.findAll().
                stream().map(member -> member.toDto()).
                collect(Collectors.toList());
        return memberDtoList;
    }

    //회원중복체크 -> 이름+이메일
    public boolean validateDuplicateUser(JoinDto joinDto){
        log.info("memberService : validateDuplicateUser");
        Optional<Member> findMember = memberRepository.findByNameAndEmail(joinDto.getName(), joinDto.getEmail());
        if(findMember.isPresent()){
            return true;
            //throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
        return false;
    }

    //내정보 조회
    public MemberDto findMember(Long id){
        log.info("memberService : findMember");
        return memberRepository.findById(id).get().toDto();
    }

    // 내정보 수정
    @Transactional
    public void updateMember(Long id, UpdateMemberDto updateMemberDto){
        memberRepository.findById(id).get().updateMemberInfo(updateMemberDto);
    }

    //회원탈퇴
    @Transactional
    public void deleteMember(Long id){
        memberRepository.deleteById(id);
    }

    //캐쉬충전
    @Transactional
    public void chargeCash(Long id , int cash){
        memberRepository.findById(id).get().chargeCash(cash);
    }

    //내 주문내역 조회
    public List<OrderDto> findMemberOrders(Long id){
        return memberRepository.findById(id).get().getOrderList().
                stream().map(o -> o.toDto()).collect(Collectors.toList());
    }

    //내 리뷰 조회
    public List<ReviewDto> findMemberReviews(Long id){
        return memberRepository.findById(id).get().getReviewList().
                stream().map(r -> r.toDto()).collect(Collectors.toList());
    }

}
