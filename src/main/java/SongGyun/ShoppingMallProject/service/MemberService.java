package SongGyun.ShoppingMallProject.service;

import SongGyun.ShoppingMallProject.domain.Member;
import SongGyun.ShoppingMallProject.domain.Role;
import SongGyun.ShoppingMallProject.dto.*;
import SongGyun.ShoppingMallProject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Optional;
import java.util.Random;
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
        if(validateDuplicateUser(joinDto)){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
        //인증키 만들고 이메일 보내기
        String authenticationKey = createKey();
        sendSimpleMessage(joinDto.getEmail(), authenticationKey);

        Member member = joinDto.toEntity();
        Member memberForJoin = member.createMemberForJoin(member.getName(), member.getLoginId(), member.getPassword(), member.getEmail(), member.getPhoneNum(), authenticationKey, 0, Role.BEFORE);

        memberRepository.save(memberForJoin);
    }

    //회원가입시 보낼 메세지 작성
    private MimeMessage createMessage(String to, String authenticationKey)throws Exception{
        log.info("UserService : createMessage1");
        System.out.println("보내는 대상 : "+ to);
        System.out.println("인증 번호 : "+authenticationKey);
        MimeMessage  message = emailSender.createMimeMessage();
        log.info("UserService : createMessage2");
        message.addRecipients(Message.RecipientType.TO, to);//보내는 대상
        message.setSubject("Ace" + "회원가입 이메일 인증");//제목

        String msgg="";
        msgg+= "<div style='margin:100px;'>";
        msgg+= "<h1> 안녕하세요 Ace입니다. </h1>";
        msgg+= "<br>";
        msgg+= "<p>아래 코드를 회원가입 창으로 돌아가 입력해주세요<p>";
        msgg+= "<br>";
        msgg+= "<p>감사합니다!<p>";
        msgg+= "<br>";
        msgg+= "<div align='center' style='border:1px solid black; font-family:verdana';>";
        msgg+= "<h3 style='color:blue;'>회원가입 인증 코드입니다.</h3>";
        msgg+= "<div style='font-size:130%'>";
        msgg+= "CODE : <strong>";
        msgg+= authenticationKey+"</strong><div><br/> ";
        msgg+= "</div>";
        message.setText(msgg, "utf-8", "html");//내용
        //message.setFrom(new InternetAddress("properties email!","Ace"));//보내는 사람
        log.info("UserService : createMessage3");
        return message;
    }

    //회원가입시 인증키 생성
    public static String createKey() {
        StringBuffer key = new StringBuffer();
        Random rnd = new Random();

        for (int i = 0; i < 8; i++) { // 인증코드 8자리
            int index = rnd.nextInt(3); // 0~2 까지 랜덤

            switch (index) {
                case 0:
                    key.append((char) ((int) (rnd.nextInt(26)) + 97));
                    //  a~z  (ex. 1+97=98 => (char)98 = 'b')
                    break;
                case 1:
                    key.append((char) ((int) (rnd.nextInt(26)) + 65));
                    //  A~Z
                    break;
                case 2:
                    key.append((rnd.nextInt(10)));
                    // 0~9
                    break;
            }
        }
        return key.toString();
    }

    //회원가입시 이메일전송
    public void sendSimpleMessage(String to,String authenticationKey)throws Exception {
        log.info("UserService : sendSimpleMessage");
        // TODO Auto-generated method stub
        MimeMessage message = createMessage(to,authenticationKey);

        try{//예외처리
            log.info("UserService : sendSimpleMessage1");
            emailSender.send(message);
            log.info("UserService : sendSimpleMessage2");
        }catch(MailException es){
            es.printStackTrace();
            throw new IllegalArgumentException();
        }
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
