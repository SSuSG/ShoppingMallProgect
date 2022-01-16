package SongGyun.ShoppingMallProject.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateMemberDto {

    private String name;
    private String loginId;
    private String password;
    private String email;
    private String phoneNum;
    private String address;
    private int postCode;

}
