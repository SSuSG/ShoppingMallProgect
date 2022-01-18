package SongGyun.ShoppingMallProject.dto;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginDto {

    @NotEmpty
    private String loginId;

    @NotEmpty
    private String password;

}
