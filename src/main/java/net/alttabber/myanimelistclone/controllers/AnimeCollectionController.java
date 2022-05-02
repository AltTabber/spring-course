package net.alttabber.myanimelistclone.controllers;

import net.alttabber.myanimelistclone.data.AnimeTitle;
import net.alttabber.myanimelistclone.resource.AnimeCollectionResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/anime")
public class AnimeCollectionController {

    private AnimeCollectionResource animeCollectionResource;

    @Autowired
    public AnimeCollectionController(AnimeCollectionResource animeCollectionResource) {
        this.animeCollectionResource = animeCollectionResource;
    }

    @GetMapping("/add")
    public String getAnimeAddForm(Model model, @Nullable AnimeTitle animeTitle){
        model.addAttribute("animeTitle", new AnimeTitle());
        return "animeForm";
    }

    @PostMapping("/add")
    public String addAnimeTitle(@ModelAttribute AnimeTitle animeTitle, Model model){
        this.animeCollectionResource.addAnimeTitleToCollection(animeTitle);
        model.addAttribute("animeTitle", animeTitle);
        model.addAttribute("animeTitleCount", this.animeCollectionResource.getSizeOfCollection());
        return "animeFormResult";
    }

    @PostMapping("/delete")
    public String remove(Model model){
        boolean isCollectionNotEmpty = this.animeCollectionResource.removeLastAnimeTitle();
        if(!isCollectionNotEmpty){
            return getAnimeAddForm(model, null);
        }
        model.addAttribute("animeTitle", this.animeCollectionResource.getLastAnimeTitle());
        model.addAttribute("animeTitleCount", this.animeCollectionResource.getSizeOfCollection());

        return "animeFormResult";
    }

}
