package SongGyun.ShoppingMallProject.dto;

import SongGyun.ShoppingMallProject.domain.Rating;
import SongGyun.ShoppingMallProject.domain.Review;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Builder
public class WriteReviewDto {

    private Long itemId;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    private String title;
    private String contents;


    //리뷰 작성시에 만들어질 리뷰!
    public Review createReview(){
        return Review.builder()
                .rating(rating)
                .title(title)
                .contents(contents)
                .build();
    }

}
