package SongGyun.ShoppingMallProject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Builder
@Getter
@Entity
@AllArgsConstructor
public class Image {

    @Id
    @GeneratedValue
    @Column(name = "uploadfile_id")
    private Long id;

    private String uploadFileName;
    private String storeFileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public Image() {
    }
}
