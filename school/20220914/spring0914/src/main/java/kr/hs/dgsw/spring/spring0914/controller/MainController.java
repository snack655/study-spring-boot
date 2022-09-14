package kr.hs.dgsw.spring.spring0914.controller;

import kr.hs.dgsw.spring.spring0914.components.ACompo;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    ACompo aCompo;

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    public MainController(ACompo aCompo) {
        this.aCompo = aCompo;
    }

    @GetMapping("")
    public String index() {
        aCompo.doA();
        return "main";
    }

    @GetMapping("freeboard")
    public String freeboard(Model model) {

        List list = sqlSessionTemplate.selectList("test.finda");
        System.out.println(list);

        model.addAttribute("list", list);
        model.addAttribute("aaa", "a값");

        return "freeboard";
    }
}
