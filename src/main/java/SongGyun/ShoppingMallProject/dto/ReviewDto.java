package SongGyun.ShoppingMallProject.dto;

import SongGyun.ShoppingMallProject.domain.Rating;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Builder
public class ReviewDto {

    private Long id;
    private Long itemId;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    private String title;
    private String contents;

}
