package store.unibly.web.admin;
import org.springframework.data.jpa.repository.JpaRepository;
import store.unibly.web.member.Member;

public interface AdminRepository extends JpaRepository<Member,String> {

}
