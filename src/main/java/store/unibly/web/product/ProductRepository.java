package store.unibly.web.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import store.unibly.web.market.MarketType;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where p.market.type = :type order by p.id DESC")
    List<Product> findByMarketTypeJpql(@Param("type") MarketType type);

    @Query("select p from Product p where p.market.type = :type and p.category = :category order by p.id DESC")
    List<Product> findByCategoryJpql(@Param("type") MarketType type, @Param("category") ProductCategory category);

    @Query("select p from Product p where p.market.id = :id order by p.id DESC")
    List<Product> findByMarketIdJpql(@Param("id") Integer id);
}
