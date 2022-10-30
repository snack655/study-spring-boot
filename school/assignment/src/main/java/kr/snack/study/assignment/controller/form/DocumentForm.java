package kr.snack.study.assignment.controller.form;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter @Setter
public class DocumentForm {

    private Long id;

    @NotBlank(message = "제목을 입력해 주세요.")
    @Size(max = 100, message = "내용은 최대 100글자까지 입니다.")
    private String title;

    @NotBlank(message = "내용을 입력해 주세요.")
    @Size(max = 1000, message = "내용은 최대 1000글자까지 입니다.")
    private String content;

    @NotBlank(message = "저자를 입력해 주세요.")
    @Size(max = 50, message = "저자는 최대 50글자까지 입니다.")
    private String writer;

    private int viewCount;

    private LocalDateTime writeTime;

}
