package kr.snack.study.assignment.controller;

import kr.snack.study.assignment.controller.form.DocumentForm;
import kr.snack.study.assignment.domain.Document;
import kr.snack.study.assignment.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @GetMapping("/write")
    public String createForm(Model model) {
        model.addAttribute("form", new DocumentForm());
        return "documents/documentWrite";
    }

    @PostMapping("/write")
    public String create(@Valid DocumentForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("에러 발생");
            return "documents/documentWrite";
        } else {
            Document document = Document.createDocument(
                    form.getTitle(),
                    form.getContent(),
                    form.getWriter()
            );

            documentService.saveItem(document);
            return "redirect:list";
        }
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Document> documents = documentService.findDocuments();
        Collections.sort(documents);
        model.addAttribute("documents", documents);
        return "documents/documentList";
    }

    @GetMapping("/view/{documentId}")
    public String view(@PathVariable("documentId") Long documentId, Model model) {
        Document document = documentService.findOne(documentId);
        model.addAttribute("document",document);
        document.addViewCount();
        documentService.saveItem(document);
        return "documents/documentView";
    }

    @GetMapping("/update/{documentId}")
    public String updateDocumentForm(@PathVariable("documentId") Long documentId, Model model) {
        Document document = documentService.findOne(documentId);

        DocumentForm form = new DocumentForm();
        form.setId(document.getId());
        form.setTitle(document.getTitle());
        form.setContent(document.getContent());
        form.setWriter(document.getWriter());
        form.setViewCount(document.getViewCount());
        form.setWriteTime(document.getWriteTime());

        model.addAttribute("form", form);
        return "documents/documentUpdate";
    }

    @PostMapping("/update/{documentId}")
    public String updateDocument(@PathVariable String documentId, DocumentForm form) {
        documentService.updateDocument(
                Long.parseLong(documentId),
                form.getTitle(),
                form.getContent(),
                form.getWriter()
        );

        return "redirect:/list";
    }

}

