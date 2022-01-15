package SongGyun.ShoppingMallProject.controller;

import SongGyun.ShoppingMallProject.domain.Member;
import SongGyun.ShoppingMallProject.dto.*;
import SongGyun.ShoppingMallProject.service.*;
import SongGyun.ShoppingMallProject.web.argumentresolver.Login;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final ItemService itemService;
    private final OrderService orderService;
    private final NoticeService noticeService;
    private final QaService qaService;

    //회원가입
    @PostMapping("/join")
    public boolean createMember(@Valid @RequestBody JoinDto joinDto , BindingResult result) throws Exception {
        if(result.hasErrors()){
            //오류가있으면
            log.info("memberController : createUser오류");
        }
        //중복가입방지
        if(!memberService.validateDuplicateUser(joinDto)){
            memberService.join(joinDto);
            return true;
        }
        return false;
    }

    //아이디 중복체크
    @GetMapping("/join/id")
    public boolean checkLoginIdDuplicate(@RequestBody String loginId) {
        log.info("memberController : checkLoginIdDuplicate");
        //true -> 아이디중복 , false -> 아이디중복 없음
        return memberService.checkLoginIdDuplicate(loginId);
    }

    //이메일 인증
    @GetMapping("/join/mail")
    public boolean authenticationEmail(
            @Login Member loginMember,
            @RequestBody String authenticationKey
    ){
        log.info("memberController : authenticationEmail");
        return memberService.IsEqualAuthenticationKey(loginMember.getId(), authenticationKey);
    }

    //아이디 찾기
    @GetMapping("/member/id")
    public String findLoginId(@RequestBody FindLoginIdDto findLoginIdDto){
        log.info("memberController : findLoginId");
        return memberService.findLoginId(findLoginIdDto);
    }

    //비밀번호 찾기
    @GetMapping("/member/pw")
    public String findPassword(@RequestBody FindPasswordDto findPasswordDto){
        log.info("memberController : findPassword");
        return memberService.findPassword(findPasswordDto);
    }


    //모든회원조회 -> admin만 가능
    @GetMapping("/admin/members")
    public List<MemberDto> findMembers(){
        log.info("memberController : findMembers");
        return memberService.findAllMembers();
    }

    //모든상품조회 -> admin만 가능
    @GetMapping("/admin/items")
    public List<ItemDto> findItems(){
        log.info("memberController : findItems");
        return itemService.findAllItems();
    }

    //모든주문조회 -> admin만 가능
    @GetMapping("/admin/orders")
    public List<OrderDto> findOrders(){
        log.info("memberController : findOrders");
        return orderService.findAllOrders();
    }

    //이미지?
    //상품등록 -> admin만 가능
    @PostMapping("/admin/item")
    public void registerItem(){
        log.info("memberController : registerItem");
    }


    //공지사항등록 -> admin만 가능
    @PostMapping("/admin/notice")
    public void writeNotice(
            @Login Member loginMember,
            @RequestBody NoticeDto noticeDto){
        log.info("memberController : writeNotice");
        noticeService.createNotice(noticeDto , loginMember);
    }

    //QA답변 -> admin만 가능
    @PostMapping("/admin/qa")
    public void answerQa(@RequestBody AnswerQaDto answerQaDto){
        log.info("memberController : answerQa");
        qaService.answerQa(answerQaDto);
    }

    //QA작성
    @PostMapping("")
    public void writeQa(@RequestBody WriteQaDto writeQaDto , @Login Member loginMember){
        log.info("memberController : writeQa");
        qaService.createQa(writeQaDto, loginMember);
    }

    //QA상세조회
    @PostMapping("")
    public QaDto viewMyQa(@RequestBody Long id){
        log.info("memberController : viewMyQa");
        return qaService.readQa(id);
    }


    //리뷰작성
    @PostMapping("")
    public void writeReview(){
        log.info("memberController : writeReview");
    }





    /*
    //내정보
    @GetMapping("/mypage")
    public Member viewMyPage(){
        log.info("memberController : viewMyPage");
    }


    //회원정보수정
    @PostMapping("/mypage/update")
    public UpdateMemberDto updateMember(){
        log.info("memberController : updateMember");
    }

    //회원탈퇴
    @PostMapping("/mypage/resign")
    public void resign(){
        log.info("memberController : resign");
    }

    //충전하기
    @PostMapping("/mypage/cash")
    public void chargeCash(){
        log.info("memberController : chargeCash");
    }


    //내 주문내역 조회
    @GetMapping("/mypage/orders")
    public OrderDto viewMyOrder(){
        log.info("memberController : viewMyOrder");
    }

    //내 qa내역 조회
    @GetMapping("/mypage/qa")
    public List<QaDto> viewMyQaList(@Login Member loginMember){
        log.info("memberController : viewMyQaList");
        return qaService.findAllQa(loginMember);
    }

    //내 리뷰 조회
    @GetMapping("/mypage/review")
    public ReviewDto viewMyReview(){
        log.info("memberController : viewMyReview");
    }


    //장바구니 담기
    @PostMapping("/basket")
    public void addToBasket(){
        log.info("memberController : addToBasket");
    }

    //장바구니 페이지
    @GetMapping("/basket")
    public BasketDto viewMyBasket(){
        log.info("memberController : viewMyBasket");
    }

    //공지사항 리스트
    @GetMapping("/service/notice")
    public List<NoticeDto> findNotices(){
        log.info("memberController : findNotices");
    }


    //공지사항 상세조회
    @GetMapping("/service/notice")
    public NoticeDto readNotice(){
        log.info("memberController : readNotice");
    }


    //QA작성
    @PostMapping("/service/qa")
    public void writeQa(){
        log.info("memberController : writeQa");
    }

     */





}
