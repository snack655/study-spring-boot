package kr.dgsw.snack.ex01_springboot.controller;

import kr.dgsw.snack.ex01_springboot.components.A;
import kr.dgsw.snack.ex01_springboot.components.B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BController {

    @Autowired A a;
    @Autowired B b;

    @GetMapping("bb")
    public String bb() {
        a.doA();
        b.doB();
        return "bb";
    }
}
