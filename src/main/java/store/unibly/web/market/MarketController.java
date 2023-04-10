package store.unibly.web.market;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import store.unibly.web.product.ProductService;

@RequestMapping("/market")
@RequiredArgsConstructor
@Controller
public class MarketController {
    private final ProductService productService;

    @GetMapping(value = "/{marketType}")
    public String marketType(Model model, @PathVariable("marketType") String type){
        model.addAttribute("products", this.productService.marketType(MarketType.valueOf(type)));
        return "market/market_type";
    }

    @GetMapping(value = "/{marketType}/{category}")
    public String productListByMarketType(Model model, @PathVariable("marketType") String type, @PathVariable("category") String category){
        // model.addAttribute("products",productService.productListByMarket(MarketType.valueOf(type), ProductCategory.valueOf(category)));
        return "product/product_category";
    }
}