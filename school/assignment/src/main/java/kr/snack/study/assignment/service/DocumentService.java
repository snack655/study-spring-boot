package kr.snack.study.assignment.service;

import kr.snack.study.assignment.domain.Document;
import kr.snack.study.assignment.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;

    @Transactional
    public Long saveItem(Document document) {
        return documentRepository.save(document);
    }

    @Transactional
    public void updateDocument(Long documentId, String title, String content, String writer) {
        Document findDocument = documentRepository.findOne(documentId);
        findDocument.setTitle(title);
        findDocument.setContent(content);
        findDocument.setWriter(writer);
    }

    public List<Document> findDocuments() {
        return documentRepository.findAll();
    }

    public Document findOne(Long documentId) {
        return documentRepository.findOne(documentId);
    }

    public void deleteDocument(Long documentId) {
        documentRepository.delete(documentId);
    }

}
