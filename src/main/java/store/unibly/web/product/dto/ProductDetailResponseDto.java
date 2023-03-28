package store.unibly.web.product.dto;

import lombok.Getter;
import store.unibly.web.market.Market;
import store.unibly.web.product.Product;

@Getter
public class ProductDetailResponseDto {
    private Market market;
    private String name;
    private Integer price;
    private Integer sale;
    private String mainImg;
    private String detailImg;
    private String detailDesc;

    public ProductDetailResponseDto(Product entity){
        this.market=entity.getMarket();
        this.name=entity.getName();
        this.price=entity.getPrice();
        this.sale=entity.getSale();
        this.mainImg=entity.getMainImg();
        this.detailImg=entity.getDetailImg();
        this.detailDesc=entity.getDetailDesc();
    }
}
