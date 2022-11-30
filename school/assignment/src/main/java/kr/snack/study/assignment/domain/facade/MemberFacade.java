package kr.snack.study.assignment.domain.facade;

import kr.snack.study.assignment.domain.entity.Member;
import kr.snack.study.assignment.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberFacade {

    private final MemberRepository memberRepository;

    public Member getCurrentMember() {
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        return getMemberById(id);
    }

    private Member getMemberById(String id) {
        return memberRepository.findById(id)
                .orElseThrow();
    }

}
