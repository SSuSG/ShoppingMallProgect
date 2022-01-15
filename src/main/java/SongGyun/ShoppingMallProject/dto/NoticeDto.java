package SongGyun.ShoppingMallProject.dto;

import SongGyun.ShoppingMallProject.domain.Notice;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NoticeDto {

    private Long id;
    private String title;
    private String contents;
    private Long memberId;      //작성자id
    private String memberName;      //작성자


    public Notice toEntity(){
        return Notice.builder()
                .id(id)
                .title(title)
                .contents(contents)
                .build();
    }
}
