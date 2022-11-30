package kr.snack.study.assignment.controller;

import kr.snack.study.assignment.controller.form.LoginForm;
import kr.snack.study.assignment.controller.form.RegisterForm;
import kr.snack.study.assignment.controller.util.ScriptUtils;
import kr.snack.study.assignment.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

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
            @ModelAttribute("form") @Valid LoginForm form,
            HttpServletResponse response,
            BindingResult bindingResult
    ) throws IOException {
        System.out.println("----------------------- 여기 들어왔는지만 좀 봐야겠노..");
        if (bindingResult.hasErrors()) {
            System.out.println("로그인에서 걸렸습니다.... 제발 제발 걸렸닥 해줘");
            ScriptUtils.alertAndMovePage(response, bindingResult.toString(), "/members/login");
        }

        String token = memberService.login(form);
        Cookie cookie = new Cookie("token", token);
        cookie.setPath("/");
        cookie.setMaxAge(1000 * 60 * 60);
        response.addCookie(cookie);
        return "redirect:/list";
    }

    @GetMapping("/user/register")
    public String registerForm(Model model) {
        model.addAttribute("form", new RegisterForm());
        return "members/register";
    }

    @PostMapping("/user/register")
    public String register(
            @ModelAttribute("form") @Valid RegisterForm form,
            BindingResult bindingResult,
            HttpServletResponse response
    ) throws IOException {

        if (bindingResult.hasErrors()) {
            ScriptUtils.alert(response, bindingResult.toString());
            return "members/register";
        }
        memberService.register(form);
        return "redirect:/user/login";
    }


}
