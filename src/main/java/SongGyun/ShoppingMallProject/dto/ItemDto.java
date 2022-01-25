package SongGyun.ShoppingMallProject.dto;

import SongGyun.ShoppingMallProject.domain.Item;
import SongGyun.ShoppingMallProject.domain.ItemStatus;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class ItemDto {

    private Long id;
    private String itemName;        //상품명
    private String size;            //상품사이즈
    private List<ImageDto> base64Images;
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
                .color(color)
                .itemInfo(itemInfo)
                .price(price)
                .imageList(new ArrayList<>())
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

    public void setImageDtoList(List<ImageDto> imageDtoList){
        this.base64Images = new ArrayList<>();

        for (ImageDto imageDto : imageDtoList) {
            this.base64Images.add(imageDto);
        }


    }

}
