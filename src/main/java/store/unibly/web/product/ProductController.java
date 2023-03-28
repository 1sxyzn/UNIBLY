package store.unibly.web.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/product")
@RequiredArgsConstructor
@Controller
public class ProductController {
    private final ProductService productService;

    @GetMapping(value = "/detail/{id}")
    public String detail() {
        return "product/product_detail";
    }
}
