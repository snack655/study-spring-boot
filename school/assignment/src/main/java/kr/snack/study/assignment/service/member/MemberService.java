package kr.snack.study.assignment.service.member;

import kr.snack.study.assignment.domain.Member;

import java.util.List;

public interface MemberService {

    void saveMember(Member member);

    List<Member> findMembers();

    Member findOne(Long memberId);

    void deleteMember(Long memberId);

}
