package SongGyun.ShoppingMallProject.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String categoryName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory" , fetch = FetchType.LAZY)
    private List<Category> childCategory;


    @OneToMany(mappedBy = "category" , cascade = CascadeType.ALL)
    private List<Item> itemList = new ArrayList<>();

    //==연관관계 편의 메소드==//

    //==비즈니스 로직==//
}
