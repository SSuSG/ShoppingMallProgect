package SongGyun.ShoppingMallProject.repository;

import SongGyun.ShoppingMallProject.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {

    public boolean existsByLoginId(String loginId);

    public Optional<Member> findByLoginId(String loginId);

    public Optional<Member> findByName(String name);

    public Optional<Member> findByNameAndEmail(String name,String email);

    public Optional<Member> findByNameAndEmailAndLoginId(String name,String email ,String loginId);

}
