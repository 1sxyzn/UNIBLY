package store.unibly.web.market;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class MarketTest {
    @Autowired
    MarketRepository marketRepository;

    @Test
    public void 마켓_데이터_추가(){
        String name = "Nike";
        MarketType type = MarketType.valueOf("Brand");

        Market m1 = Market.builder()
                .name(name)
                .type(type)
                .build();

        marketRepository.save(m1);

        List<Market> markets = marketRepository.findAll();
        assertThat(markets.get(0).getName()).isEqualTo(name);
    }
}
