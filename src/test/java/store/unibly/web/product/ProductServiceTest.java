package store.unibly.web.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import store.unibly.web.market.MarketType;
import store.unibly.web.product.dto.*;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ProductServiceTest {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @Test
    @DisplayName("없는 상품 id를 조회할 때에는 IllegalArgumentException")
    public void detailInfoFailTest(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            productService.detailInfo(0);
        });
    }

    @Test
    @DisplayName("JPQL 사용해서 마켓 type별로 상품 조회하기")
    public void marketTypeTest(){
        MarketType t1 = MarketType.valueOf("Brand");
        List<ProductListResponseDto> p1 = productService.marketType(t1);
        assertThat(p1.size()).isEqualTo(2);

        MarketType t2 = MarketType.valueOf("Shop");
        List<ProductListResponseDto> p2 = productService.marketType(t2);
        assertThat(p2.size()).isEqualTo(0);
    }
}