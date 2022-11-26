package kr.snack.study.assignment.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    private String id;
    private String password;
    private String name;

    /**
     * Member 객체를 만들어 반환해 주는 함수입니다.
     * @param id 사용자 아이디
     * @param password 사용자 비밀번호
     * @param name 사용자 이름
     * @return 만들어진 Member 객체 반환
     */
    public static Member createMember(String id, String password, String name) {
        Member member = new Member();
        member.setId(id);
        member.setPassword(password);
        member.setName(name);
        return member;
    }

}
