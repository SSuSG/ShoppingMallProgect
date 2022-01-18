package SongGyun.ShoppingMallProject.domain;

import SongGyun.ShoppingMallProject.dto.ReviewDto;
import SongGyun.ShoppingMallProject.dto.WriteReviewDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
public class Review extends TimeEntity{
    @Id
    @GeneratedValue
    @Column(name = "review_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    private String title;
    private String contents;

    public Review() {
    }

    public ReviewDto toDto(){
        return ReviewDto.builder()
                .id(id)
                .itemId(item.getId())
                .rating(rating)
                .title(title)
                .contents(contents)
                .build();
    }

    //==연관관계 편의 메소드==//
    public void setMember(Member member){
        this.member = member;
        member.getReviewList().add(this);
    }

    public void setItem(Item item){
        this.item = item;
        item.getReviewList().add(this);
    }

    //==비즈니스 로직==//
}
