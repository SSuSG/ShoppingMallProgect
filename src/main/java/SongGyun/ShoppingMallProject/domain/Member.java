package SongGyun.ShoppingMallProject.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;
    private String loginId;
    private String password;
    private String email;
    private String authenticationKey;
    private String phoneNum;
    private String address;
    private int postCode;
    private int cash;


    @Enumerated(EnumType.STRING)
    private Role role;

    /*
    @OneToMany
    private List<Order> orderList = new ArrayList<>();

    @OneToMany
    private List<Qa> QaList = new ArrayList<>();

    @OneToMany
    private List<Notice> noticeList = new ArrayList<>();

    @OneToOne
    private Basket basket;

    @OneToMany
    private List<Review> reviewList = new ArrayList<>();

     */
    @Builder
    public Member(Long id , String name , String loginId , String password , String email, Role role,
                  String phoneNum , String address , int postCode , int cash , String authenticationKey){
        this.id = id;
        this.name = name;
        this.loginId = loginId;
        this.password = password;
        this.email = email;
        this.role = role;
        this.authenticationKey = authenticationKey;
        this.phoneNum = phoneNum;
        this.address = address;
        this.postCode = postCode;
        this.cash = cash;
    }

    //==연관관계 편의 메소드==//




    //==비즈니스 로직==//
}
