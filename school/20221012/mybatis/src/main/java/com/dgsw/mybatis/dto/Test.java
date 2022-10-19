package com.dgsw.mybatis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Getter // getter 자동 만들기
@Setter // setter 자동 만들기
@ToString // toString 자동 만들기
@AllArgsConstructor // 모든 파라메타가 있는 생성자 자동만들기
public class Test {

    private Integer idx;

    @NotEmpty
    private String aa;

    @NotEmpty
    private String bb;

}
