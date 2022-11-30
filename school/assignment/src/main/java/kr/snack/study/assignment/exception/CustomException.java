package kr.snack.study.assignment.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class CustomException extends RuntimeException {
    private ErrorProperty errorProperty;
}
