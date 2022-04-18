package net.alttabber.myanimelistclone.controllers;

import net.alttabber.myanimelistclone.service.HelloPlanetManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private HelloPlanetManager helloPlanetManager;

    @GetMapping("/home")
    public String getMainPage(Model model){
        helloPlanetManager.helloPlanet();
        model.addAttribute("randomString", "123123");
        return "main";
    }

}
