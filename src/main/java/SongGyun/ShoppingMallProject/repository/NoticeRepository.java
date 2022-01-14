package SongGyun.ShoppingMallProject.repository;

import SongGyun.ShoppingMallProject.domain.Member;
import SongGyun.ShoppingMallProject.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice,Long> {
}
