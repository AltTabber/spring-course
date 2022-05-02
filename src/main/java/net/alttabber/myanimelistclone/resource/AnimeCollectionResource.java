package net.alttabber.myanimelistclone.resource;

import net.alttabber.myanimelistclone.data.AnimeTitle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AnimeCollectionResource {

    private List<AnimeTitle> animeTitleList;

    public AnimeCollectionResource() {
        this.animeTitleList = new ArrayList<>();
    }

    public AnimeTitle getLastAnimeTitle(){
        if(animeTitleList != null && !animeTitleList.isEmpty()){
            return animeTitleList.get(animeTitleList.size()-1);
        }
        return null;
    }

    public boolean removeLastAnimeTitle(){
        if(animeTitleList != null && !animeTitleList.isEmpty()){
            animeTitleList.remove(animeTitleList.size()-1);
            return !animeTitleList.isEmpty();
        }
        return false;
    }

    public Integer getSizeOfCollection(){
        return animeTitleList.size();
    }

    public void addAnimeTitleToCollection(AnimeTitle animeTitle){
        animeTitleList.add(animeTitle);
    }

}
