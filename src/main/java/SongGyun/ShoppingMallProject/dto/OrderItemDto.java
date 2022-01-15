package SongGyun.ShoppingMallProject.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderItemDto {

    private Long id;
    private Long orderId;
    private Long itemId;
    private String itemName;
}
