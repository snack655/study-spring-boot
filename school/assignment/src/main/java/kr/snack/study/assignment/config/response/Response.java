package kr.snack.study.assignment.config.response;

import lombok.Getter;

@Getter
public class Response {

    private final int status;
    private final String message;

    public Response(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
