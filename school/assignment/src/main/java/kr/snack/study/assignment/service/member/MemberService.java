package kr.snack.study.assignment.service.member;

import kr.snack.study.assignment.domain.entity.Member;

import java.util.List;

public interface MemberService {

    void saveMember(Member member);

    List<Member> findMembers();

    Member findOne(String memberId);

    void deleteMember(String memberId);

    //Boolean login(Member member);

}
