package store.unibly.web.market;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import store.unibly.web.product.*;

@RequestMapping("/market")
@RequiredArgsConstructor
@Controller
public class MarketController {
    private final ProductService productService;

    @GetMapping(value = "/{marketType}")
    public String marketType(Model model, @PathVariable("marketType") String type){
        model.addAttribute("products", this.productService.productListByMarketType(MarketType.valueOf(type)));
        model.addAttribute("type", type);
        return "market/market_type";
    }

    @GetMapping(value = "/{marketType}/{category}")
    public String category(Model model, @PathVariable("marketType") String type, @PathVariable("category") String category){
        model.addAttribute("products",productService.productListByCategory(MarketType.valueOf(type), ProductCategory.valueOf(category)));
        model.addAttribute("category", category);
        return "product/product_category";
    }
}