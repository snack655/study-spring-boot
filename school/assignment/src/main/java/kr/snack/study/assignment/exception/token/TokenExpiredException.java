package kr.snack.study.assignment.exception.token;

import kr.snack.study.assignment.exception.CustomException;

public class TokenExpiredException extends CustomException {

    private TokenExpiredException() {
        super(MemberErrorCode.TOKEN_EXPIRED);
    }

    public static final CustomException EXCEPTION = new TokenExpiredException();
}
