package SongGyun.ShoppingMallProject.dto;

import SongGyun.ShoppingMallProject.domain.Role;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
public class MemberDto {

    private Long id;
    private String name;
    private String loginId;
    private String password;
    private String email;
    private String phoneNum;
    private String address;
    private int postCode;
    private int cash;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public MemberDto(Long id , String name , String loginId , String password , String email , String phoneNum
    , String address , int postCode , int cash , Role role){
        this.id = id;
        this.name = name;
        this.loginId = loginId;
        this.password = password;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.postCode = postCode;
        this.cash = cash;
        this.role = role;
    }
}
