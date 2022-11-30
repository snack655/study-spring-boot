package kr.snack.study.assignment.service.member;

import kr.snack.study.assignment.controller.form.LoginForm;
import kr.snack.study.assignment.controller.form.RegisterForm;

public interface MemberService {

    String login(LoginForm loginForm);
    void register(RegisterForm registerForm);

}
