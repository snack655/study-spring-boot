package kr.snack.study.assignment.service.document;

import kr.snack.study.assignment.domain.entity.Document;

import java.util.List;

public interface DocumentService {

    /**
     * 문서를 저장하는 함수
     * @param document
     */
    void saveDocument(Document document);

    /**
     * 문서를 파라미터에 맞춰서 업데이트 합니다.
     * @param documentId
     * @param title
     * @param content
     * @param writer
     */
    void updateDocument(Long documentId, String title, String content, String writer);

    /**
     * 모든 문서를 조회합니다.
     * @return List<Document>
     */
    List<Document> findDocuments();

    /**
     * 아이디에 맞는 문서를 조회합니다.
     * @param documentId
     * @return Document
     */
    Document findOne(Long documentId);

    /**
     * 문서를 삭제하는 함수.
     * @param documentId
     */
    void deleteDocument(Long documentId);
}
