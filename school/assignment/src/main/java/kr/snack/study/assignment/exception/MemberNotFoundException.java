package kr.snack.study.assignment.exception;

import kr.snack.study.assignment.exception.token.MemberErrorCode;

public class MemberNotFoundException extends CustomException {

    private MemberNotFoundException() {
        super(MemberErrorCode.USER_NOT_FOUND);
    }

    public static final CustomException EXCEPTION = new MemberNotFoundException();
}
