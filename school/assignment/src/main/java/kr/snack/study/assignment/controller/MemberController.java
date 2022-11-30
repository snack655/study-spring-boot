package kr.snack.study.assignment.controller;

import kr.snack.study.assignment.controller.form.DocumentForm;
import kr.snack.study.assignment.controller.form.LoginForm;
import kr.snack.study.assignment.controller.form.RegisterForm;
import kr.snack.study.assignment.domain.entity.Member;
import kr.snack.study.assignment.exception.MemberNotFoundException;
import kr.snack.study.assignment.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/user/login")
    public String loginForm(Model model) {
        model.addAttribute("form", new LoginForm());
        return "members/login";
    }

    @PostMapping("/user/login")
    public String login(
            @ModelAttribute("form") @Valid LoginForm form
    ) {
        memberService.login(form);
        return "documents/documentList";
    }

    @GetMapping("/user/register")
    public String registerForm(Model model) {
        model.addAttribute("form", new RegisterForm());
        return "members/register";
    }

    @PostMapping("/user/register")
    public String register(@ModelAttribute("form") @Valid RegisterForm form, BindingResult bindingResult) {
        memberService.register(form);
        return "redirect:/user/login";
    }


}
