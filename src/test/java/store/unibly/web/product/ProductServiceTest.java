package store.unibly.web.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}