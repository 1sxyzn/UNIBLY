package store.unibly.web.market;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.unibly.web.market.dto.MarketDetailResponseDto;
import store.unibly.web.market.dto.MarketListResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MarketService {
    private final MarketRepository marketRepository;

    @Transactional(readOnly = true)
    public List<MarketListResponseDto> marketListByType(MarketType type){
        return this.marketRepository.findByTypeJpql(type).stream()
                .map(market -> new MarketListResponseDto(market))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MarketDetailResponseDto detailInfo(Integer id){
        Market market = marketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 마켓입니다."));
        return new MarketDetailResponseDto(market);
    }
}
