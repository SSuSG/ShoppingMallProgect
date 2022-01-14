package SongGyun.ShoppingMallProject.repository;

import SongGyun.ShoppingMallProject.domain.BasketItem;
import SongGyun.ShoppingMallProject.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketItemRepository extends JpaRepository<BasketItem,Long> {
}
