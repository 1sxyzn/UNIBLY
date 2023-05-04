package store.unibly.web.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String loginId;

    private String password;

    private String name;

    @Column(unique = true)
    private String phone;

    @Enumerated(EnumType.STRING)
    private MemberLevel level;

    private String address;

    @Builder
    public Member(String loginId, String password, String name, String phone, String address){
        this.loginId=loginId;
        this.password=password;
        this.name=name;
        this.phone=phone;
        this.address=address;
    }
}
