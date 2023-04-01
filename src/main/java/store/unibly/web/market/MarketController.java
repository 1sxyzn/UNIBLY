package store.unibly.web.market;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import store.unibly.web.product.ProductService;

@RequiredArgsConstructor
@Controller
public class MarketController {
    private final ProductService productService;

    @GetMapping(value = "/{marketType}")
    public String marketType(Model model, @PathVariable("marketType") String type){
        model.addAttribute("product", this.productService.marketType(MarketType.valueOf(type)));
        return "market/market_type";
    }
}