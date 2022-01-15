package SongGyun.ShoppingMallProject.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BasketItem {

    @Id
    @GeneratedValue
    @Column(name = "basketItem_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "basket_id")
    private Basket basket;

    private int orderCount;

    //==연관관계 편의 메소드==//
    public void setItem(Item item){
        this.item = item;
        item.getBasketItemList().add(this);
    }

    //==비즈니스 로직==//


}
