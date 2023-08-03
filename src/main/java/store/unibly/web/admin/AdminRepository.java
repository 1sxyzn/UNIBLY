package store.unibly.web.admin;
import org.springframework.data.jpa.repository.JpaRepository;
import store.unibly.web.product.Product;

public interface AdminRepository extends JpaRepository<Product,Integer> { // admin 에서 다루는 상품들

}
