package com.dgsw.mybatis.controller;

import com.dgsw.mybatis.dto.Test;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("board")
public class BoardController {

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    // select 해서 테이블 내용 뿌려주는거
    @GetMapping("findall")
    public String findall(Model model){
        System.out.println("findall");
        System.out.println("여기요");

        List<Test> testlist = sqlSessionTemplate.selectList("test.findall");

        model.addAttribute("a","10");
        model.addAttribute("testlist", testlist);

        return "findall";
    }

    //insert 해서 테이블에 행 삽입
    @GetMapping("insert")
    public String insert(Test test){
        return "insert";
    }

    @PostMapping("insert")
    public String pinsert(@Valid Test test, BindingResult bindingResult, Model model){
//        System.out.println(aa);
//        System.out.println(bb);
        // single quota '

        System.out.println("실행되고 있니?");

        if( bindingResult.hasErrors()){
            System.out.println("에러 있음");
//            model.addAttribute("error",true);
            return "insert";
        }

        System.out.println(test);
        sqlSessionTemplate.insert("insert", test);

        return "redirect:/board/findall";
    }

    @PostMapping("findall")
    public String delete(Long[] args) {
        System.out.println("삭제요");
        Arrays.stream(args).forEach(arg ->
                sqlSessionTemplate.delete("delete", arg));
        return "redirect:/board/findall";
    }

}
