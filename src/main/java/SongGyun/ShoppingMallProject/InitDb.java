package SongGyun.ShoppingMallProject;

import SongGyun.ShoppingMallProject.domain.Category;
import SongGyun.ShoppingMallProject.domain.Item;
import SongGyun.ShoppingMallProject.domain.Member;
import SongGyun.ShoppingMallProject.domain.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

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
            //멤버
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

            //카테고리
            Category 아우터 = Category.builder().categoryName("아우터").build();
            Category 코트 = Category.builder().categoryName("코트").parentCategory(아우터).build();
            Category 블레이져 = Category.builder().categoryName("블레이져").parentCategory(아우터).build();
            Category 패딩 = Category.builder().categoryName("패딩").parentCategory(아우터).build();
            List<Category> child = new ArrayList<>();
            child.add(코트);
            child.add(블레이져);
            child.add(패딩);
            아우터.setChildCategory(child);

            //아이템
            Item item1 = Item.builder().itemName("싱글코트").price(10000).size("L").color("블랙").category(코트).build();
            Item item2 = Item.builder().itemName("더블코트").price(15000).size("L").color("베이지").category(코트).build();
            Item item3 = Item.builder().itemName("블레이져A").price(30000).size("M").color("블랙").category(블레이져).build();
            Item item4 = Item.builder().itemName("블레이져B").price(30000).size("M").color("블랙").category(블레이져).build();
            Item item5 = Item.builder().itemName("패딩A").price(40000).size("L").color("화이트").category(패딩).build();
            Item item6 = Item.builder().itemName("패딩B").price(50000).size("M").color("블랙").category(패딩).build();

            em.persist(아우터);

            em.persist(item1);
            em.persist(item2);
            em.persist(item3);
            em.persist(item4);
            em.persist(item5);
            em.persist(item6);

            em.persist(member);
            em.persist(member1);
            em.persist(member2);
        }



    }

}
