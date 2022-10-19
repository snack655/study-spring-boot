package kr.snack.study.assignment.controller;

import kr.snack.study.assignment.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;
}
