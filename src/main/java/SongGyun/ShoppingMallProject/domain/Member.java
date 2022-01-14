package SongGyun.ShoppingMallProject.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
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
    private String phoneNum;
    private String authenticationKey;   //이메일 인증키키    private String phoneNum;
    private String address;
    private int postCode;
    private int cash;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "member" , cascade = CascadeType.ALL)
    private List<Order> orderList = new ArrayList<>();

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<Qa> qaList = new ArrayList<>();

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<Notice> noticeList = new ArrayList<>();


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
