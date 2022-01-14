package SongGyun.ShoppingMallProject.repository;

import SongGyun.ShoppingMallProject.domain.Basket;
import SongGyun.ShoppingMallProject.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket,Long> {
}
