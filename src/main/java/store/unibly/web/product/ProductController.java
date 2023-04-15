package store.unibly.web.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import store.unibly.web.market.MarketType;

@RequestMapping("/product")
@RequiredArgsConstructor
@Controller
public class ProductController {
    private final ProductService productService;

    @GetMapping(value = "/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("product", this.productService.detailInfo(id));
        return "product/product_detail";
    }

    @GetMapping(value = "/market/{marketType}")
    public String marketType(Model model, @PathVariable("marketType") String type){
        model.addAttribute("products", this.productService.productListByMarketType(MarketType.valueOf(type)));
        model.addAttribute("type", type);
        return "product/market_type";
    }

    @GetMapping(value = "/market/{marketType}/{category}")
    public String category(Model model, @PathVariable("marketType") String type, @PathVariable("category") String category){
        model.addAttribute("products",productService.productListByCategory(MarketType.valueOf(type), ProductCategory.valueOf(category)));
        model.addAttribute("category", category);
        return "product/product_category";
    }
}
