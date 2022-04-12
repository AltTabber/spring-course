package net.alttabber.myanimelistclone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/home")
    public String getMainPage(){
        System.out.println("Anime govno!");
        return "main";
    }

}
