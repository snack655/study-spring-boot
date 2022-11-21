package kr.snack.study.assignment.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String email;
    private String password;

    /**
     * Member 객체를 만들어 반환해 주는 함수입니다.
     * @param email
     * @param password
     * @return
     */
    public static Member createMember(String email, String password) {
        Member member = new Member();
        member.setEmail(email);
        member.setPassword(password);
        return member;
    }

}
