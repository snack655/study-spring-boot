package com.dgsw.studyjpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class AA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String aa;
    private String bb;

    private LocalDateTime cdate;
    private LocalDateTime mdate;

    private int count;

}
