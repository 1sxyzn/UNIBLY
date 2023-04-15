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

    @Test
    public void 마켓_데이터_추가_모든타입(){
        // 브랜드
        String name1 = "ADIDAS";
        MarketType type1 = MarketType.valueOf("Brand");
        String logoImg1 = "https://i0.wp.com/msc-overseas.jp/img/brand/commonlogo/logo_adidas_originals.png?w=750&ssl=1";
        Market m1 = Market.builder()
                .name(name1)
                .type(type1)
                .logoImg(logoImg1)
                .build();

        marketRepository.save(m1);

        // 쇼핑몰
        String name2 = "니어웨어";
        MarketType type2 = MarketType.valueOf("Shop");
        String logoImg2 = "https://is5-ssl.mzstatic.com/image/thumb/Purple125/v4/b0/28/ba/b028ba31-9e84-4732-a101-53f3eb424606/AppIcon-0-0-1x_U007emarketing-0-0-0-10-0-0-sRGB-0-0-0-GLES2_U002c0-512MB-85-220-0-0.png/512x512bb.jpg";

        Market m2 = Market.builder()
                .name(name2)
                .type(type2)
                .logoImg(logoImg2)
                .build();

        marketRepository.save(m2);

        // 셀럽
        String name3 = "크림치즈마켓";
        MarketType type3 = MarketType.valueOf("Celeb");
        String logoImg3 = "https://m.creamcheese.co.kr/web/product/big/202007/3eeef7ac2be4422b0f7d57bac1969c6a.gif";

        Market m3 = Market.builder()
                .name(name3)
                .type(type3)
                .logoImg(logoImg3)
                .build();

        marketRepository.save(m3);
    }
}
