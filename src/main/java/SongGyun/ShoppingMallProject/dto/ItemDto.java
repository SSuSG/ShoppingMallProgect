package SongGyun.ShoppingMallProject.dto;

import SongGyun.ShoppingMallProject.domain.Item;
import SongGyun.ShoppingMallProject.domain.ItemStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ItemDto {

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

    public Item toEntity(){
        return Item.builder()
                .id(id)
                .itemName(itemName)
                .size(size)
                .imagePath(imagePath)
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

}
