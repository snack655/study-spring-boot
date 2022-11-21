package kr.snack.study.assignment.controller;

import kr.snack.study.assignment.controller.form.DocumentForm;
import kr.snack.study.assignment.domain.Document;
import kr.snack.study.assignment.service.document.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    /**
     * 문서 폼을 받아와서 띄워줍니다.
     * @param model
     * @return write
     */
    @GetMapping("/write")
    public String createForm(Model model) {
        model.addAttribute("form", new DocumentForm());
        return "documents/documentWrite";
    }

    /**
     * 폼에 따라서 문서를 생성합니다.
     * @param form
     * @param bindingResult
     * @return redirect list
     */
    @PostMapping("/write")
    public String create(@ModelAttribute("form") @Valid DocumentForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "documents/documentWrite";
        }

        Document document = Document.createDocument(
                form.getTitle(),
                form.getContent(),
                form.getWriter()
        );

        documentService.saveDocument(document);
        return "redirect:list";
    }

    /**
     * 문서 리스트로 보기
     * sort를 통해서 문서를 최신순으로 정렬
     * @param model
     * @return list
     */
    @GetMapping("/list")
    public String list(Model model) {
        List<Document> documents = documentService.findDocuments();
        Collections.sort(documents);
        model.addAttribute("documents", documents);
        return "documents/documentList";
    }

    /**
     * 문서 자세히 보기
     * @param documentId
     * @param model
     * @return view
     */
    @GetMapping("/view/{documentId}")
    public String view(@PathVariable("documentId") Long documentId, Model model) {
        Document document = documentService.findOne(documentId);
        model.addAttribute("document",document);
        document.addViewCount();
        documentService.saveDocument(document);
        return "documents/documentView";
    }

    /**
     * 문서 업데이트 폼을 가져옴
     * @param documentId
     * @param model
     * @return update
     */
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

    /**
     * 문서를 수정된 폼에 따라 업데이트 함
     * @param form
     * @param bindingResult
     * @param documentId
     * @return list
     */
    @PostMapping("/update/{documentId}")
    public String updateDocument(
            @ModelAttribute("form") @Valid DocumentForm form,
            BindingResult bindingResult,
            @PathVariable String documentId
    ) {

        if (bindingResult.hasErrors()) {
            return "redirect:/update/"+documentId;
        }

        documentService.updateDocument(
                Long.parseLong(documentId),
                form.getTitle(),
                form.getContent(),
                form.getWriter()
        );

        return "redirect:/list";
    }

    /**
     * 문서 삭제
     * @param documentId
     */
    @DeleteMapping("/delete/{documentId}")
    public @ResponseBody void deleteDocument(@PathVariable Long documentId) {
        documentService.deleteDocument(documentId);
    }

}

