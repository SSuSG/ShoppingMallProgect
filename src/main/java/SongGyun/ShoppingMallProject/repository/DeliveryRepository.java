package SongGyun.ShoppingMallProject.repository;

import SongGyun.ShoppingMallProject.domain.Delivery;
import SongGyun.ShoppingMallProject.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery,Long> {
}
