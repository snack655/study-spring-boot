package com.dgsw.mybatis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class 학생수강 {
    private Integer h_idx;
    private Integer t_idx;

    private Integer grade;
    private String name;
    private String 과목명;
    

}
