package SongGyun.ShoppingMallProject.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QaDto {

    private Long id;
    private Long itemId;
    private String title;
    private String contents;
    private String answer;
}
