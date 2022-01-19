package SongGyun.ShoppingMallProject.dto;

import SongGyun.ShoppingMallProject.domain.Item;
import SongGyun.ShoppingMallProject.domain.ItemStatus;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@Getter
public class CreateItemDto {

    private String itemName;        //상품명
    private String size;            //상품사이즈
    private String color;           //상품 컬러
    private String itemInfo;        //상품 상세 설명
    private int price;              //상품 가격
    private int stockQuantity;      //상품 재고량
    private MultipartFile[] multipartFiles;


    public CreateItemDto(){
    }

    public Item toEntity(){
        return Item.builder()
                .itemName(itemName)
                .size(size)
                .color(color)
                .itemInfo(itemInfo)
                .price(price)
                .stockQuantity(stockQuantity)
                .imageList(new ArrayList<>())
                .build();
    }

}
