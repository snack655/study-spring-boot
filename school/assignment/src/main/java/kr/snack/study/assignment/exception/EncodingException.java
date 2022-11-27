package kr.snack.study.assignment.exception;

import org.springframework.http.HttpStatus;

public class EncodingException extends CustomException{

    private EncodingException() {
        super(HttpStatus.NOT_FOUND, "인코딩 오류");
    }

    public static final CustomException EXCEPTION = new EncodingException();
}
