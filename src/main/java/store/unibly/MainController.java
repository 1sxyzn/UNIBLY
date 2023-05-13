package store.unibly;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import store.unibly.web.product.ProductService;

@RequiredArgsConstructor
@Controller
public class MainController {
    private final ProductService productService;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("products",productService.mainList());
        return "main";
    }
}
