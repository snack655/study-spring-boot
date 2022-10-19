package com.dgsw.studyjpa.controller;

import com.dgsw.studyjpa.entity.AA;
import com.dgsw.studyjpa.repository.AARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/aa")
public class AAController {

    @GetMapping("save")
    public String save() {
        System.out.println("save");
        return "save";
    }

    @GetMapping("savesetting")
    public String savesetting() {
        System.out.println("savesetting");

        AA aa = new AA();
        aa.setAa("aa");

        aa.setCdate(LocalDateTime.now());
        aaRepository.save(aa);

        return "save";

    }

}
