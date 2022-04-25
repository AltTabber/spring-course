package net.alttabber.myanimelistclone.controllers;

import net.alttabber.myanimelistclone.data.AnimeTitle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/anime")
public class AnimeCollectionController {


    @GetMapping("/add")
    public String getAnimeAddForm(Model model){
        model.addAttribute("animeTitle", new AnimeTitle());
        return "animeForm";
    }

    @PostMapping("/add")
    public String addAnimeTitle(@ModelAttribute AnimeTitle animeTitle, Model model){
        model.addAttribute("animeTitle", animeTitle);
        return "animeFormResult";
    }

}
