package com.mustache.bbs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MustacheController {
    @GetMapping(value = "/hi")
    public String mustacheCon(Model model){
        model.addAttribute("username", "ho"); // view에 값을 넘김
        return "greetings"; // greetings 라는 이름의 view를 리턴
    }


    @GetMapping(value = "/hi/{id}")
    public String mustacheCon(@PathVariable String id, Model model) {
        model.addAttribute("username", "ho"); // view에 값을 넘김
        model.addAttribute("id", "id"); // view에 값을 넘김
        return "greetings"; // greetings 라는 이름의 view를 리턴
    }
}
