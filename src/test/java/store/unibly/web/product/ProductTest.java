package store.unibly.web.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import store.unibly.web.market.Market;
import store.unibly.web.market.MarketRepository;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ProductTest {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    MarketRepository marketRepository;

    @Test
    public void 상품_데이터_추가(){
        List<Market> markets = marketRepository.findAll();

        Market market = markets.get(0);
        String name = "NIKE Air Force";
        Integer price = Integer.valueOf("139000");
        Integer sale = Integer.valueOf("10");
        ProductCategory category = ProductCategory.valueOf("Shoes");
        LocalDateTime createDate = LocalDateTime.now();

        Product p1 = Product.builder()
                .market(market)
                .name(name)
                .price(price)
                .sale(sale)
                .category(category)
                .createDate(createDate)
                .build();

        productRepository.save(p1);

        List<Product> products = productRepository.findAll();
        assertThat(products.get(0).getName()).isEqualTo(name);
    }

    @Test
    public void 상품_데이터_추가2(){
        List<Market> markets = marketRepository.findAll();

        Market market = markets.get(0);
        String name = "NIKE Air Max";
        Integer price = Integer.valueOf("175200");
        Integer sale = Integer.valueOf("0");
        ProductCategory category = ProductCategory.valueOf("Shoes");
        LocalDateTime createDate = LocalDateTime.now();

        Product p1 = Product.builder()
                .market(market)
                .name(name)
                .price(price)
                .sale(sale)
                .category(category)
                .createDate(createDate)
                .build();

        productRepository.save(p1);

        List<Product> products = productRepository.findAll();
        assertThat(products.get(1).getName()).isEqualTo(name);
    }
}
