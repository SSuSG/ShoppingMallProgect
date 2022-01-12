package SongGyun.ShoppingMallProject;

import SongGyun.ShoppingMallProject.domain.Member;
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
                    .loginId("psg1234")
                    .password("1234")
                    .email("@naver")
                    .phoneNum("9587")
                    .build();

            em.persist(member);
        }



    }

}
