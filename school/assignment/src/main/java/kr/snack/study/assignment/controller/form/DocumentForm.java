package kr.snack.study.assignment.controller.form;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter @Setter
public class DocumentForm {

    private Long id;

    @NotEmpty(message = "제목은 필수입니다.")
    @Size(max = 100, message = "내용은 최대 100 글자입니다.")
    private String title;

    @NotEmpty(message = "내용은 필수입니다.")
    @Size(max = 1000, message = "내용은 최대 1000 글자입니다.")
    private String content;

    @NotEmpty(message = "작성자는 필수입니다.")
    @Size(max = 50, message = "작성자는 최대 50 글자입니다.")
    private String writer;

    private int viewCount;

    private LocalDateTime writeTime;


}
