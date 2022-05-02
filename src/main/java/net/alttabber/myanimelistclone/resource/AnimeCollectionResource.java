package net.alttabber.myanimelistclone.resource;

import net.alttabber.myanimelistclone.data.AnimeTitle;
import net.alttabber.myanimelistclone.data.AnimeTitleStatus;
import net.alttabber.myanimelistclone.data.AnimeTitleType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AnimeCollectionResource {

    private List<AnimeTitle> animeTitleList;

    public AnimeCollectionResource() {
        this.animeTitleList = Arrays.asList(
                new AnimeTitle("Naruto", "5", "/images/Naruto.jpg", AnimeTitleType.TV, AnimeTitleStatus.COMPLETED),
                new AnimeTitle("Bakemonogatari", "1", "/images/Bakemonogatari.jpg", AnimeTitleType.TV, AnimeTitleStatus.DROPPED),
                new AnimeTitle("Your Name", "8", "/images/KimiNoNaWa.jpg", AnimeTitleType.Movie, AnimeTitleStatus.COMPLETED),
                new AnimeTitle("Hikaru no Go", "10", "/images/HikaruNoGo.jpg", AnimeTitleType.TV, AnimeTitleStatus.COMPLETED),
                new AnimeTitle("Spy X Family", "", "/images/SpyXFamily.jpg", AnimeTitleType.TV, AnimeTitleStatus.PLANTOWATCH)
        );
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

    public List<AnimeTitle> getAnimeTitleList() {
        return animeTitleList;
    }
}
