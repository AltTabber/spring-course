package net.alttabber.myanimelistclone.resource;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class PaginatorService {

    public PaginatorService() {
    }

    public <T> List<T> getPage(List<T> baseList, Integer pageNumber, Integer pageSize){
        List<List<T>> pages = Lists.partition(baseList, pageSize);
        if( pageNumber >= pages.size() - 1 ){
            return null;
        }
        return pages.get(pageNumber);
    }

    public <T> List<T> getPageWithModel(List<T> baseList, Integer pageNumber, Integer pageSize, Model model){
        List<List<T>> pages = Lists.partition(baseList, pageSize);
        model.addAttribute("page", pageNumber);
        model.addAttribute("pageAmount", pages.size());
        model.addAttribute("pageSize", pageSize);
        if( pageNumber > pages.size() ){
            return null;
        }
        return pages.get(pageNumber - 1);
    }

}
