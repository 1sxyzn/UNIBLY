package store.unibly.web.market.dto;

import lombok.Getter;
import store.unibly.web.market.Market;

@Getter
public class MarketListResponseDto {
    private Integer id;
    private String name;
    private String logoImg;

    public MarketListResponseDto(Market entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.logoImg = entity.getLogoImg();
    }
}
