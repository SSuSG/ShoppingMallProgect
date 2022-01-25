package SongGyun.ShoppingMallProject.domain;

import SongGyun.ShoppingMallProject.dto.ItemDto;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@Slf4j
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String itemName;        //상품명
    private String size;            //상품사이즈
    private String imagePath;       //상품 이미지
    private String color;           //상품 컬러
    private String itemInfo;        //상품 상세 설명
    private int price;              //상품 가격
    private int stockQuantity;      //상품 재고량
    private ItemStatus itemStatus;  //상품 (판매)상태
    private Double ratingAverage;   //별점 평균
    private int oneCount;
    private int twoCount;
    private int threeCount;
    private int fourCount;
    private int fiveCount;
    //private int totalCount;   //총 평가인원수

    @OneToMany(mappedBy = "item" , cascade = CascadeType.ALL)
    private List<Image> imageList = new ArrayList<>();

    @OneToMany(mappedBy = "item" , cascade = CascadeType.ALL)
    private List<Qa> qaList = new ArrayList<>();

    @OneToMany(mappedBy = "item" , cascade = CascadeType.ALL)
    private List<BasketItem> basketItemList = new ArrayList<>();

    @OneToMany(mappedBy = "item" , cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "item" , cascade = CascadeType.ALL)
    private List<OrderItem> orderItemList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public Item() {
    }


    public ItemDto toDto() {
        return ItemDto.builder()
                .id(id)
                .itemName(itemName)
                .size(size)
                .color(color)
                .itemInfo(itemInfo)
                .price(price)
                .stockQuantity(stockQuantity)
                .itemStatus(itemStatus)
                .ratingAverage(ratingAverage)
                .oneCount(oneCount)
                .threeCount(twoCount)
                .threeCount(threeCount)
                .fourCount(fourCount)
                .fiveCount(fiveCount)
                .build();
    }


    //==비즈니스 로직==//


    //==연관 관계 메소드==//
    public void setOrderItem(OrderItem orderItem){
        this.orderItemList.add(orderItem);
        orderItem.setItem(this);
    }

    public void setImage(Image image){
        image.setItem(this);
        this.imageList.add(image);
    }




}
