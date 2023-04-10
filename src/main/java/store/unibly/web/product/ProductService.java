package store.unibly.web.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.unibly.web.market.MarketRepository;
import store.unibly.web.market.MarketType;
import store.unibly.web.product.dto.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductListResponseDto> mainList(){
        return this.productRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).stream()
                .map(product -> new ProductListResponseDto(product))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProductDetailResponseDto detailInfo(Integer id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
        return new ProductDetailResponseDto(product);
    }

    @Transactional(readOnly = true)
    public List<ProductListResponseDto> marketType(MarketType type){
        return this.productRepository.findByMarketTypeJpql(type).stream()
                .map(product -> new ProductListResponseDto(product))
                .collect(Collectors.toList());
    }
}
