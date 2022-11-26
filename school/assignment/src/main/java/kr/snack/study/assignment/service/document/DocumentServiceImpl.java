package kr.snack.study.assignment.service.document;

import kr.snack.study.assignment.domain.entity.Document;
import kr.snack.study.assignment.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    @Transactional
    public void saveDocument(Document document) {
        documentRepository.save(document);
    }

    @Transactional
    public void updateDocument(Long documentId, String title, String content, String writer) {
        Document findDocument = documentRepository.findById(documentId)
                        .orElseThrow();
        findDocument.setTitle(title);
        findDocument.setContent(content);
        findDocument.setWriter(writer);
        findDocument.setWriteTime(LocalDateTime.now());
    }

    public List<Document> findDocuments() {
        return documentRepository.findAll();
    }

    public Document findOne(Long documentId) {
        return documentRepository.findById(documentId)
                .orElseThrow();
    }

    @Transactional
    public void deleteDocument(Long documentId) {
        documentRepository.deleteById(documentId);
    }

}
