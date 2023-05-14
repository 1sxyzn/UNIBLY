package store.unibly.web.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import store.unibly.web.member.dto.SignUpForm;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member signUp(SignUpForm signUpForm) {
        Member member = Member.builder()
                .loginId(signUpForm.getLoginId())
                .password(passwordEncoder.encode(signUpForm.getPassword1()))
                .name(signUpForm.getName())
                .phone(signUpForm.getPhone())
                .address(signUpForm.getAddress())
                .role(signUpForm.getRole())
                .build();
        return memberRepository.save(member);
    }
}
