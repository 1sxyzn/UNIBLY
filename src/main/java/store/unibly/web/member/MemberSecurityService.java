package store.unibly.web.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberSecurityService implements UserDetailsService {
    // UserDetailsService는 loadUserByUsername 메서드를 필수로 구현해야하는 인터페이스
    // loadUserByUsername는 id로 비밀번호 조회 후 리턴
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException{
        Optional<Member> memberEx = this.memberRepository.findByLoginId(loginId);
        if(memberEx.isEmpty()){
            throw new UsernameNotFoundException("아이디가 존재하지 않습니다.");
        }
        Member member = memberEx.get();
        List<GrantedAuthority> auth = new ArrayList<>();
        if("ROLE_ADMIN".equals(member.getRole())){
            auth.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        else{
            auth.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return new User(member.getLoginId(), member.getPassword(), auth);
    }
}
