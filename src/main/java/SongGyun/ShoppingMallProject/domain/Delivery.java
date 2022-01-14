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
public class Delivery {
    @Id
    @GeneratedValue
    @Column(name = "delevery_id")
    private Long id;

    private String address;
    private DeliveryStatus deliveryStatus;

    @OneToOne(mappedBy = "delivery",fetch = FetchType.LAZY)
    private Order order;

    //==연관관계 편의 메소드==//

    //==비즈니스 로직==//
}
