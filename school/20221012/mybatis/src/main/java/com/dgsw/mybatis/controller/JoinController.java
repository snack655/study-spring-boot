package com.dgsw.mybatis.controller;

import com.dgsw.mybatis.dto.학생수강;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("join")
@Controller
public class JoinController {

    @Autowired
    SqlSession sqlSessionTemplate;

    @GetMapping("main")
    public String main(Model model){
        List<학생수강> list =
                sqlSessionTemplate.selectList("join.student");

        System.out.println(list);

        model.addAttribute("studentlist",list);
        return "join/main";

    }
}
