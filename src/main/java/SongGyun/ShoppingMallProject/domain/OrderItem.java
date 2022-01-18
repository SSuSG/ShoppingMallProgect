package SongGyun.ShoppingMallProject.domain;

import SongGyun.ShoppingMallProject.dto.OrderItemDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "orderItem_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public OrderItem() {

    }

    public OrderItemDto toDto(OrderItem orderItem){
        return OrderItemDto.builder()
                .id(id)
                .orderId(order.getId())
                .itemId(item.getId())
                .itemName(item.getItemName())
                .build();
    }

    //==연관관계 편의 메소드==//

    //==비즈니스 로직==//



}
