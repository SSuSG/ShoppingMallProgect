package SongGyun.ShoppingMallProject.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Basket {
    @Id
    @GeneratedValue
    @Column(name = "basket_id")
    private Long id;

    @OneToOne(mappedBy = "basket" , cascade = CascadeType.ALL)
    private Member member;

    @OneToMany(mappedBy = "basket" , cascade = CascadeType.ALL)
    private List<BasketItem> basketItemList = new ArrayList<>();


    //==연관관계 편의 메소드==//


    //==비즈니스 로직==//

}
