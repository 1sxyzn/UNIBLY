package store.unibly.web.product;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import store.unibly.web.market.Market;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @NotNull
    private Market market;

    @Column(length = 50, unique = true)
    @NotNull
    private String name;

    @NotNull
    private Integer price;

    @ColumnDefault("0")
    @NotNull
    private Integer sale;

    private String mainImg; // 이미지 경로 저장

    private String detailImg; // 이미지 경로 저장

    @Column(columnDefinition = "TEXT")
    private String detailDesc;

    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    @NotNull
    private LocalDateTime createDate;

    @Builder
    public Product(Market market, String name, Integer price, Integer sale,
                   String mainImg, String detailImg, String detailDesc,
                   ProductCategory category, LocalDateTime createDate){
        this.market=market;
        this.name=name;
        this.price=price;
        this.sale=sale;
        this.mainImg=mainImg;
        this.detailImg=detailImg;
        this.detailDesc=detailDesc;
        this.category=category;
        this.createDate=createDate;
    }
}
