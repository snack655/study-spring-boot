package kr.snack.study.assignment.domain;

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

    public static Document createDocument(String title, String content, String writer) {
        Document document = new Document();
        document.setTitle(title);
        document.setContent(content);
        document.setWriter(writer);
        document.setViewCount(0);
        document.setWriteTime(LocalDateTime.now());
        return document;
    }

    public void addViewCount() {
        this.viewCount += 1;
    }

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
