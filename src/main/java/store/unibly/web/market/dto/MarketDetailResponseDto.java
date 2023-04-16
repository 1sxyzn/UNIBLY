package store.unibly.web.market.dto;

import lombok.Getter;
import store.unibly.web.market.Market;
import store.unibly.web.market.MarketType;

@Getter
public class MarketDetailResponseDto {
    private Integer id;
    private String name;
    private MarketType type;
    private String logoImg;

    public MarketDetailResponseDto(Market entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.type = entity.getType();
        this.logoImg = entity.getLogoImg();
    }
}
