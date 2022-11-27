package kr.snack.study.assignment.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public abstract class CustomException extends RuntimeException {
    private HttpStatus code;
    private String message;
}
