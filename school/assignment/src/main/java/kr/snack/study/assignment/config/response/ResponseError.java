package kr.snack.study.assignment.config.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseError extends Response{

    @Builder
    public ResponseError(int status, String message) {
        super(status, message);
    }
}
