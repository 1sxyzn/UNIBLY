package store.unibly.web.member.dto;

import lombok.Getter;
import store.unibly.web.member.MemberRole;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
public class SignUpForm {
    @Size(min=5, max=20)
    @NotEmpty(message = "ID를 입력해 주세요.")
    private String loginId;

    @NotEmpty(message = "비밀번호를 입력해 주세요.")
    private String password1;

    @NotEmpty(message = "비밀번호를 다시 한번 입력해 주세요.")
    private String password2;


    @Size(min=1, max=20)
    @NotEmpty(message = "이름을 입력해 주세요.")
    private String name;

    @Size(min=9, max=11)
    @NotEmpty(message = "전화번호를 입력해 주세요.")
    private String phone;

    private String address;

    private MemberRole role;
}
