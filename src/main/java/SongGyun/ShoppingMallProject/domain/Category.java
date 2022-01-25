package SongGyun.ShoppingMallProject.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@Setter
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String categoryName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "par_category_id")
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory" , cascade = CascadeType.ALL)
    private List<Category> childCategory;

    @OneToMany(mappedBy = "category" , cascade = CascadeType.ALL)
    private List<Item> itemList = new ArrayList<>();

    public Category() {
    }

    //==연관관계 편의 메소드==//

    //==비즈니스 로직==//
}


