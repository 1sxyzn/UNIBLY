package store.unibly.web.market;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import store.unibly.web.market.dto.MarketListResponseDto;
import store.unibly.web.product.dto.ProductListResponseDto;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class MarketServiceTest {
    @Autowired
    MarketRepository marketRepository;

    @Autowired
    MarketService marketService;

    @Test
    @DisplayName("타입 별로 마켓 목록 불러오기")
    public void marketListByTypeTest(){
        MarketType mtb = MarketType.Brand;
        MarketType mts = MarketType.Shop;

        List<MarketListResponseDto> mb = marketService.marketListByType(mtb);
        List<MarketListResponseDto> ms = marketService.marketListByType(mts);

        assertThat(mb.size()).isEqualTo(1); // 현재 저장된 Brand는 Nike 하나만 존재
        assertThat(ms.size()).isEqualTo(0); // 현재 저장된 Shop 없음
    }
}
