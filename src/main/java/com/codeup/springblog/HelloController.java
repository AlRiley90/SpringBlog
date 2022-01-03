package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }

    @GetMapping("/join")
    public String showJoinForm(){
        return "join";
    }

    @PostMapping("join")
    public String joinCohort(@RequestParam(name="cohort") String cohort, Model model){
    model.addAttribute("cohort", cohort);
    return "join";
    }
}
