package kr.snack.study.assignment.controller;

import kr.snack.study.assignment.config.Sha512Encrypt;
import kr.snack.study.assignment.controller.form.LoginForm;
import kr.snack.study.assignment.controller.form.RegisterForm;
import kr.snack.study.assignment.domain.entity.Member;
import kr.snack.study.assignment.exception.MemberNotFoundException;
import kr.snack.study.assignment.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final Sha512Encrypt sha512Encrypt;

    @GetMapping("/user/login")
    public String loginForm(Model model) {
        model.addAttribute("form", new LoginForm());
        return "members/login";
    }

    @PostMapping("/user/login")
    public String login(@ModelAttribute("form") @Valid LoginForm form,
                        BindingResult bindingResult,
                        HttpServletResponse response,Model model
    ) throws IOException {
        System.out.println(form.getId());
        String password = sha512Encrypt.encode(form.getPassword());

        Member member;
        try {
            member = memberService.login(form.getId(), password);
        } catch (MemberNotFoundException e) {

            PrintWriter out = response.getWriter();
            out.println("<script>alert('" + e.getMessage() + "');</script> ");
            out.flush();

            return "members/login";
        }

        Cookie cookie = new Cookie("memberId", member.getId());
        response.addCookie(cookie);

        return "redirect:/list";
    }

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
                sha512Encrypt.encode(form.getPassword()),
                form.getName()
        );

        memberService.saveMember(member);

        return "redirect:/user/login";
    }


}
