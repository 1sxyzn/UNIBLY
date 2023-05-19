package store.unibly.web.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import store.unibly.web.member.dto.SignUpForm;
import org.springframework.dao.DataIntegrityViolationException;

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
            System.out.println(bindingResult.getAllErrors());
            return "member/signup";
        }

        if (!signUpForm.getPassword1().equals(signUpForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "비밀번호가 일치하지 않습니다.");
            return "member/signup";
        }

        try{
            memberService.signUp(signUpForm);
        }
        catch (DataIntegrityViolationException e){ // SQL 혹은 DATA 문제 ex) 중복되면 안되는 정보가 중복 등록 되었을 때
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "member/signup";
        }
        catch (Exception e) { // 그 외의 다른 오류일 경우
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "member/signup";
        }

        return "redirect:/";
    }
}
