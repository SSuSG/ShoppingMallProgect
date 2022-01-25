package SongGyun.ShoppingMallProject.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ImageDto {

    private String imageName;
    private String base64Image;

}
