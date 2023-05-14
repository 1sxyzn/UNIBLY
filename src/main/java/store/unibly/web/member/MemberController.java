package store.unibly.web.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import store.unibly.web.member.dto.SignUpForm;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signup")
    public String signUp(SignUpForm signUpForm) {
        return "member/signup";
    }

    @PostMapping("/signup")
    public String signUp(@Valid SignUpForm signUpForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "member/signup";
        }

        if (!signUpForm.getPassword1().equals(signUpForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "비밀번호가 일치하지 않습니다.");
            return "member/signup";
        }

        memberService.signUp(signUpForm);

        return "redirect:/";
    }
}
