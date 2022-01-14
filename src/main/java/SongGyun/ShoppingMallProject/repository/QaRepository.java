package SongGyun.ShoppingMallProject.repository;

import SongGyun.ShoppingMallProject.domain.Member;
import SongGyun.ShoppingMallProject.domain.Qa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QaRepository extends JpaRepository<Qa,Long> {
}
