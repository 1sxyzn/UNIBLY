package store.unibly.web.market;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import store.unibly.web.member.Member;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Entity
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, unique = true)
    @NotNull
    private String name;

    @Enumerated(EnumType.STRING)
    private MarketType type;

    private String logoImg; // 이미지 경로 저장

    @ManyToOne
    private Member manager;

    @Builder
    public Market(String name, MarketType type, String logoImg, Member manager){
        this.name=name;
        this.type=type;
        this.logoImg=logoImg;
        this.manager=manager;
    }
}
