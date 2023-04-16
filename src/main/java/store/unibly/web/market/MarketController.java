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
    private final MarketService marketService;
    private final ProductService productService;

    @GetMapping(value = "/list/{marketType}")
    public String marketList(Model model, @PathVariable("marketType") String type){
        model.addAttribute("markets",marketService.marketListByType(MarketType.valueOf(type)));
        model.addAttribute("type", type);
        return "market/market_list";
    }

    @GetMapping(value = "/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        model.addAttribute("market", marketService.detailInfo(id));
        model.addAttribute("products",productService.productListByMarketId(id));
        return "market/market_detail";
    }
}