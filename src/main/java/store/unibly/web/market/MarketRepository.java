package store.unibly.web.market;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import store.unibly.web.product.Product;

import java.util.List;

public interface MarketRepository extends JpaRepository<Market,Integer> {

    @Query("select m from Market m where m.type = :type order by m.id DESC")
    List<Market> findByTypeJpql(@Param("type") MarketType type);
}
