package SongGyun.ShoppingMallProject.dto;

import SongGyun.ShoppingMallProject.domain.Delivery;
import SongGyun.ShoppingMallProject.domain.OrderStatus;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class OrderDto {

    private Long id;
    private OrderStatus orderStatus;
    private String memberName;
    private List<OrderItemDto> orderItemDtoList;
    private Delivery delivery;

}
