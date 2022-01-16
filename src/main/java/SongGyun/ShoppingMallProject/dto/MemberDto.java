package SongGyun.ShoppingMallProject.dto;

import SongGyun.ShoppingMallProject.domain.Role;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Builder
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


}
