package kr.snack.study.assignment.service.member;

import kr.snack.study.assignment.controller.form.LoginForm;
import kr.snack.study.assignment.controller.form.RegisterForm;
import kr.snack.study.assignment.domain.entity.Member;

import java.util.List;

public interface MemberService {

    void login(LoginForm loginForm);
    void register(RegisterForm registerForm);

}
