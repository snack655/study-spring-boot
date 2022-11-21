package kr.snack.study.assignment.controller;

import kr.snack.study.assignment.controller.form.MemberForm;
import kr.snack.study.assignment.domain.Member;
import kr.snack.study.assignment.service.member.MemberService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("form", new MemberForm());
        return "member/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("form") @Valid MemberForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "redirect:login";
        }

        Member member = Member.createMember(
                form.getEmail(),
                form.getPassword()
        );

        memberService.saveMember(member);
        return "documents/documentList";
    }


}
