package SongGyun.ShoppingMallProject.domain;

import SongGyun.ShoppingMallProject.dto.QaDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
public class Qa extends TimeEntity{
    @Id
    @GeneratedValue
    @Column(name = "qa_id")
    private Long id;

    private String title;
    private String contents;
    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public Qa() {

    }

    public QaDto toDto(){
        return QaDto.builder()
                .id(id)
                .itemId(item.getId())
                .title(title)
                .contents(contents)
                .answer(answer)
                .build();

    }




    //==연관관계 편의 메소드==//
    public void setMember(Member member){
        this.member = member;
        member.getQaList().add(this);
    }

    public void setItem(Item item){
        this.item = item;
        item.getQaList().add(this);
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }

    //==비즈니스 로직==//

}
