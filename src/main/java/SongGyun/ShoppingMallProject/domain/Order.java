package SongGyun.ShoppingMallProject.domain;

import SongGyun.ShoppingMallProject.dto.MemberDto;
import SongGyun.ShoppingMallProject.dto.OrderDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends TimeEntity{
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    private OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order" , cascade =CascadeType.ALL)
    private List<OrderItem> orderItemList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;


    public OrderDto toDto(Order order) {
        return OrderDto.builder()
                .id(id)
                .orderStatus(orderStatus)
                .memberName(member.getName())
                .orderItemDtoList(orderItemList.stream()
                        .map(orderItem -> orderItem.toDto(orderItem))
                        .collect(Collectors.toList()))
                .delivery(delivery)
                .build();
    }


    //==연관관계 편의 메소드==//
    public void setMember(Member member){
        this.member = member;
        member.getOrderList().add(this);
    }

    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    public void setOrderItem(OrderItem orderItem){
        this.orderItemList.add(orderItem);
        orderItem.setOrder(this);
    }

    //==비즈니스 로직==//

}
