package kr.snack.study.assignment.service.member;

import kr.snack.study.assignment.domain.entity.Member;
import kr.snack.study.assignment.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member findOne(String memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow();
    }

    @Override
    @Transactional
    public void deleteMember(String memberId) {
        memberRepository.deleteById(memberId);
    }

//    @Override
//    public Boolean login(Member member) {
//        Member dbMember = memberRepository.findById(member.getId()).orElseThrow();
//
//        System.out.println("로그인 확인 : " + dbMember.getPassword() + " - " +  member.getPassword());
//
//        return dbMember.getPassword().equals(member.getPassword());
//    }
}
