package kr.snack.study.assignment.service;

import kr.snack.study.assignment.domain.Document;
import kr.snack.study.assignment.repository.DocumentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentServiceTest {

    @Autowired DocumentService documentService;
    @Autowired DocumentRepository documentRepository;

    @Test
    public void saveDocumentTest() throws Exception {
        //given
        Document document = Document.createDocument(
                "Hello",
                "안녕하세요 저는 최민재입니다. 테스트 테스트..",
                "Minjae"
        );

        //when
        Long savedId = documentService.saveItem(document);

        //then
        Document dbDocument = documentRepository.findOne(savedId);

        assertEquals(document.getId(), dbDocument.getId());
        assertEquals(document.getTitle(), dbDocument.getTitle());
        assertEquals(document.getContent(), dbDocument.getContent());
        assertEquals(document.getWriter(), dbDocument.getWriter());
        assertEquals(document.getViewCount(), dbDocument.getViewCount());

    }

    @Test
    public void updateDocumentTest() throws Exception {
        //given
        Document initialDocument = Document.createDocument("Init", "Hello", "Minjae");
        Long savedId = documentService.saveItem(initialDocument);

        //when
        documentService.updateDocument(savedId, "Update", "Update Test", "SongSong");

        //then
        Document document = documentRepository.findOne(savedId);

        assertEquals("Update", document.getTitle());
        assertEquals("Update Test", document.getContent());
        assertEquals("SongSong", document.getWriter());
    }



}
