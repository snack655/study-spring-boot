package kr.snack.study.assignment.repository;

import kr.snack.study.assignment.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAll();

    Optional<Member> findById(Long id);

}
