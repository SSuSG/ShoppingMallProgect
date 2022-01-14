package SongGyun.ShoppingMallProject;

import SongGyun.ShoppingMallProject.domain.Member;
import SongGyun.ShoppingMallProject.domain.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {
    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();

    }
    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;
        public void dbInit1(){
            Member member = Member.builder()
                    .name("시균")
                    .loginId("normal")
                    .password("1234")
                    .email("@naver")
                    .role(Role.NORMAL)
                    .phoneNum("9587")
                    .build();

            Member member1 = Member.builder()
                    .name("에이비")
                    .loginId("befoer")
                    .password("1234")
                    .email("@naver")
                    .role(Role.BEFORE)
                    .phoneNum("123")
                    .build();

            Member member2 = Member.builder()
                    .name("시디")
                    .loginId("admin")
                    .password("1234")
                    .email("@naver")
                    .role(Role.ADMIN)
                    .phoneNum("456")
                    .build();

            em.persist(member);
            em.persist(member1);
            em.persist(member2);
        }



    }

}
