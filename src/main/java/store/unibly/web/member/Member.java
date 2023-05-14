package store.unibly.web.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Builder
    public Member(String loginId, String password, String name, String phone, String address, MemberRole role){
        this.loginId=loginId;
        this.password=password;
        this.name=name;
        this.phone=phone;
        this.address=address;
        this.role=role;
        this.level=MemberLevel.WHITE;
    }
}
