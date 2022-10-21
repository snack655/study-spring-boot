package kr.snack.study.assignment.repository;

import kr.snack.study.assignment.domain.Document;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DocumentRepository {

    private final EntityManager em;

    public Long save(Document document) {
        if (document.getId() == null) {
            em.persist(document);
        } else {
            em.merge(document);
        }
        return document.getId();
    }

    public Document findOne(Long id) {
        return em.find(Document.class, id);
    }

    public List<Document> findAll() {
        return em.createQuery("select d from Document d", Document.class)
                .getResultList();
    }
}
