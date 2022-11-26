package kr.snack.study.assignment.controller;

import kr.snack.study.assignment.controller.form.LoginForm;
import kr.snack.study.assignment.controller.form.RegisterForm;
import kr.snack.study.assignment.domain.entity.Member;
import kr.snack.study.assignment.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/user/login")
    public String loginForm(Model model) {
        model.addAttribute("form", new LoginForm());
        return "members/login";
    }

/*    @PostMapping("/user/login")
    public String login(@ModelAttribute("form") @Valid LoginForm form, BindingResult bindingResult) {
        Member member = Member.createMember(
                form.getId(),
                passwordEncoder.encode(form.getPassword())
        );

        try {
            if (memberService.login(member)) {
                return "redirect:/list";
            } else {
                return "members/login";
            }
        } catch (NoSuchElementException e) {
            return "members/login";
        }
    }*/

    @GetMapping("/user/register")
    public String registerForm(Model model) {
        model.addAttribute("form", new RegisterForm());
        return "members/register";
    }

    @PostMapping("/user/register")
    public String register(@ModelAttribute("form") @Valid RegisterForm form, BindingResult bindingResult) {
        System.out.println(form);

        Member member = Member.createMember(
                form.getId(),
                passwordEncoder.encode(form.getPassword()),
                form.getName()
        );

        memberService.saveMember(member);

        return "redirect:/user/login";
    }


}
