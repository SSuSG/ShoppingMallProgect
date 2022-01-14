package SongGyun.ShoppingMallProject.dto;

import SongGyun.ShoppingMallProject.domain.Member;
import SongGyun.ShoppingMallProject.domain.Role;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class JoinDto {

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @NotBlank(message = "아이디를 입력해주세요.")
    private String loginId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "올바른 이메일 주소를 입력해주세요.")
    private String email;

    @NotBlank(message = "휴대폰 번호를 입력해주세요.")
    private String phoneNum;

    /* 아직 노필요
    @NotBlank(message = "비밀번호를 한번더 입력해주세요.")
    private String checkPassword;


    private String address;
    private int postCode;
    private int cash;
    */

    public Member toEntity(){
        Member member = Member.builder()
                .name(name)
                .loginId(loginId)
                .password(password)
                .email(email)
                .phoneNum(phoneNum)
                .role(Role.BEFORE)
                .build();
        return member;
    }

}
