package store.unibly.web.market;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private MarketType type;

    private String logoImg; // 이미지 경로 저장

    @Builder
    public Market(String name, MarketType type, String logoImg){
        this.name=name;
        this.type=type;
        this.logoImg=logoImg;
    }
}
