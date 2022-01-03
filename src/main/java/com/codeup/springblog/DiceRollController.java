package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class DiceRollController {

    @GetMapping("/roll-dice")
    public String showJoinForm(){
        return "roll-dice";
    }

    @PostMapping("roll-dice")
    public String viewUserGuess(@RequestParam(name= "userGuess") String userGuess, Model model){
        model.addAttribute("userGuess", userGuess);
        Random n = new Random();
        model.addAttribute("n", n.nextInt((6 - 1) + 1) + 1);
        return "roll-dice";
    }

}
