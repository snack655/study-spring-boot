package kr.snack.study.assignment.repository;

import kr.snack.study.assignment.domain.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<Document> findAll();

    Optional<Document> findById(Long id);

}
