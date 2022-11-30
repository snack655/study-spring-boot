package kr.snack.study.assignment.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    private String id;

    @Column(nullable = false, length = 500)
    private String password;

    @Column(nullable = false)
    private String name;

    /**
     * Member 객체를 만들어 반환해 주는 함수입니다.
     * @param id 사용자 아이디
     * @param password 사용자 비밀번호
     * @param name 사용자 이름
     * @return 만들어진 Member 객체 반환
     */
    @Builder
    public Member(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

}
