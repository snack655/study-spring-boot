package kr.snack.study.assignment.exception;

import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends CustomException {

    private MemberNotFoundException() {
        super(HttpStatus.NOT_FOUND, "등록되지 않은 아이디입니다");
    }

    public static final CustomException EXCEPTION = new MemberNotFoundException();
}
