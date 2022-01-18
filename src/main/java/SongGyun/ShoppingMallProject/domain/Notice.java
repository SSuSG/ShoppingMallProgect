package SongGyun.ShoppingMallProject.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
public class Notice extends TimeEntity{
    @Id
    @GeneratedValue
    @Column(name = "notice_id")
    private Long id;

    private String title;
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Notice() {

    }

    //==연관관계 편의 메소드==//
    public void setMember(Member member){
        this.member = member;
        member.getNoticeList().add(this);
    }



    //==비즈니스 로직==//
}
