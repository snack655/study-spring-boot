package kr.snack.study.assignment.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Document implements Comparable<Document> {

    @Id
    @GeneratedValue
    @Column(name = "document_id")
    private Long id;

    private String title;

    @Column(length = 1024)
    private String content;

    private String writer;
    private int viewCount;
    private LocalDateTime writeTime;

    /**
     * 파라미터에 맞는 Document 객체를 만들어 반환하는 함수입니다.
     * @param title
     * @param content
     * @param writer
     * @return document
     */
    public static Document createDocument(String title, String content, String writer) {
        Document document = new Document();
        document.setTitle(title);
        document.setContent(content);
        document.setWriter(writer);
        document.setViewCount(0);
        document.setWriteTime(LocalDateTime.now());
        return document;
    }

    /**
     * 조회수를 올려주는 함수
     */
    public void addViewCount() {
        this.viewCount += 1;
    }

    /**
     * 문서를 정렬해 주는 함수입니다.
     * 정렬의 기준은 writeTime 입니다.
     * @param document
     * @return 1 or -1
     */
    @Override
    public int compareTo(Document document) {
        if (document.writeTime.isAfter(writeTime)) {
            return 1;
        } else if (document.writeTime.isBefore(writeTime)) {
            return -1;
        }
        return 0;
    }
}
