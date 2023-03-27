package store.unibly.web.product.dto;

import lombok.Getter;
import store.unibly.web.market.Market;
import store.unibly.web.product.Product;
import store.unibly.web.product.ProductCategory;

import java.time.LocalDateTime;

@Getter
public class ProductListResponseDto {
    private Integer id;
    private Market market;
    private String name;
    private Integer price;
    private Integer sale;
    private String mainImg;
    private ProductCategory category;
    private LocalDateTime createDate;

    public ProductListResponseDto(Product entity){
        this.id=entity.getId();
        this.market=entity.getMarket();
        this.name=entity.getName();
        this.price=entity.getPrice();
        this.sale=entity.getSale();
        this.mainImg=entity.getMainImg();
        this.category=entity.getCategory();
        this.createDate=entity.getCreateDate();
    }
}
