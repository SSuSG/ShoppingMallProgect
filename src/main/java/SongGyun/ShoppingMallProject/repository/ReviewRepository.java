package SongGyun.ShoppingMallProject.repository;

import SongGyun.ShoppingMallProject.domain.Member;
import SongGyun.ShoppingMallProject.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
