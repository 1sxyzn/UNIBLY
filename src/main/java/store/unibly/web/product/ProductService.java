package store.unibly.web.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.unibly.web.product.dto.ProductListResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductListResponseDto> mainList(){
        return this.productRepository.findAll().stream()
                .map(product -> new ProductListResponseDto(product))
                .collect(Collectors.toList());
    }
}
