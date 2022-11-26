package kr.snack.study.assignment.repository;

import kr.snack.study.assignment.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

    List<Member> findAll();

    Optional<Member> findById(String id);

}
