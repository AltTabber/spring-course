package net.alttabber.myanimelistclone.controllers;

import net.alttabber.myanimelistclone.data.AnimeTitleDto;
import net.alttabber.myanimelistclone.resource.AnimeCollectionResource;
import net.alttabber.myanimelistclone.resource.PaginatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/anime")
public class AnimeCollectionController {

    private AnimeCollectionResource animeCollectionResource;
    private PaginatorService paginatorService;

    @Autowired
    public AnimeCollectionController(AnimeCollectionResource animeCollectionResource,
                                     PaginatorService paginatorService) {
        this.animeCollectionResource = animeCollectionResource;
        this.paginatorService = paginatorService;
    }

    @GetMapping("/add")
    public String getAnimeAddForm(Model model, @Nullable AnimeTitleDto animeTitleDto){
        model.addAttribute("animeTitle", new AnimeTitleDto());
        return "animeForm";
    }

    @PostMapping("/add")
    public String addAnimeTitle(@ModelAttribute AnimeTitleDto animeTitleDto, Model model){
        this.animeCollectionResource.addAnimeTitleToCollection(animeTitleDto);
        model.addAttribute("animeTitle", animeTitleDto);
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

    @GetMapping("/list")
    public String list(Model model, @Nullable @RequestParam("page") Integer pageNumber){
        if(pageNumber == null){
            pageNumber = 1;
        }
        Integer pageSize = 10;

        List<AnimeTitleDto> animeTitleDtoListPage = this.paginatorService.getPageWithModel(
                animeCollectionResource.getAnimeTitleList(), pageNumber, pageSize, model);

        model.addAttribute("animeTitleList", animeTitleDtoListPage);
        return "animeList";
    }

    @GetMapping("/{userId}/list")
    public String list(Model model, @PathVariable("userId") Long userId,
                       @Nullable @RequestParam("page") Integer pageNumber){
        if(pageNumber == null){
            pageNumber = 1;
        }
        Integer pageSize = 10;


        List<AnimeTitleDto> animeTitleDtoListPage = this.paginatorService.getPageWithModel(
                animeCollectionResource.getAnimeTitleCollection(userId), pageNumber, pageSize, model);

        model.addAttribute("animeTitleList", animeTitleDtoListPage);
        return "animeList";
    }

    @GetMapping("/createData")
    public String createList(){

        animeCollectionResource.createData();
        return "index";
    }


}
