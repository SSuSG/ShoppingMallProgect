package SongGyun.ShoppingMallProject.repository;

import SongGyun.ShoppingMallProject.domain.Item;
import SongGyun.ShoppingMallProject.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
