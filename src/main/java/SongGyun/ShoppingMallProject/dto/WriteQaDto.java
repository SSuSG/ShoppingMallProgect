package SongGyun.ShoppingMallProject.dto;

import SongGyun.ShoppingMallProject.domain.Qa;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WriteQaDto {

    private Long itemId;
    private String title;
    private String contents;

    public Qa toEntity() {
        return Qa.builder()
                .title(title)
                .contents(contents)
                .build();
    }
}
