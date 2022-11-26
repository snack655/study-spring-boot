package kr.snack.study.assignment.controller.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class LoginForm {

    @NotBlank(message = "아이디를 입력해 주세요.")
    private String id;

    @NotBlank(message = "비밀번호를 입력해 주세요.")
    private String password;

}
