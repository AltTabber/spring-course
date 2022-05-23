package net.alttabber.myanimelistclone.resource;

import net.alttabber.myanimelistclone.data.AnimeTitleDto;
import net.alttabber.myanimelistclone.data.AnimeTitleStatus;
import net.alttabber.myanimelistclone.data.AnimeTitleType;
import net.alttabber.myanimelistclone.entities.AnimeTitle;
import net.alttabber.myanimelistclone.repository.AnimeTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AnimeCollectionResource {

    AnimeTitleRepository animeTitleRepository;

    @Autowired
    public AnimeCollectionResource(AnimeTitleRepository animeTitleRepository) {
        this.animeTitleRepository = animeTitleRepository;
    }

    public AnimeTitleDto getLastAnimeTitle(){
        List<AnimeTitleDto> animeTitleDtoList = getAnimeTitleList();
        if(animeTitleDtoList != null && !animeTitleDtoList.isEmpty()){
            return animeTitleDtoList.get(animeTitleDtoList.size()-1);
        }
        return null;
    }

    public boolean removeLastAnimeTitle(){
        List<AnimeTitleDto> animeTitleDtoList = getAnimeTitleList();
        if(animeTitleDtoList != null && !animeTitleDtoList.isEmpty()){
            animeTitleDtoList.remove(animeTitleDtoList.size()-1);
            return !animeTitleDtoList.isEmpty();
        }
        return false;
    }

    public Integer getSizeOfCollection(){
        List<AnimeTitleDto> animeTitleDtoList = getAnimeTitleList();
        return animeTitleDtoList.size();
    }

    public void addAnimeTitleToCollection(AnimeTitleDto animeTitleDto){
        List<AnimeTitleDto> animeTitleDtoList = getAnimeTitleList();
        animeTitleDtoList.add(animeTitleDto);
    }

    public List<AnimeTitleDto> getAnimeTitleList() {

        List<AnimeTitleDto> outputAnimeTitleDtoList = new ArrayList<>();
        List<AnimeTitle> animeTitleList = animeTitleRepository.getAll();
        for(AnimeTitle animeTitle : animeTitleList){

            AnimeTitleDto animeTitleDto = new AnimeTitleDto();
            animeTitleDto.setId(animeTitle.getId());
            animeTitleDto.setName(animeTitle.getName());
            animeTitleDto.setDescription(animeTitle.getDescription());
            animeTitleDto.setCoverUrl(animeTitle.getCoverUrl());
            animeTitleDto.setScore(animeTitle.getScore());
            animeTitleDto.setStatus(animeTitle.getStatus());
            animeTitleDto.setType(animeTitle.getType());

            outputAnimeTitleDtoList.add(animeTitleDto);
        }

        return outputAnimeTitleDtoList;
    }

    public void createData(){

        List<AnimeTitleDto> animeTitleDtoList = Arrays.asList(
                new AnimeTitleDto("Naruto", "5", "/images/Naruto.jpg", AnimeTitleType.TV, AnimeTitleStatus.COMPLETED),
                new AnimeTitleDto("Bakemonogatari", "1", "/images/Bakemonogatari.jpg", AnimeTitleType.TV, AnimeTitleStatus.DROPPED),
                new AnimeTitleDto("Your Name", "8", "/images/KimiNoNaWa.jpg", AnimeTitleType.Movie, AnimeTitleStatus.COMPLETED),
                new AnimeTitleDto("Hikaru no Go", "10", "/images/HikaruNoGo.jpg", AnimeTitleType.TV, AnimeTitleStatus.COMPLETED),
                new AnimeTitleDto("Spy X Family", "", "/images/SpyXFamily.jpg", AnimeTitleType.TV, AnimeTitleStatus.PLANTOWATCH),
                new AnimeTitleDto("Naruto", "5", "/images/Naruto.jpg", AnimeTitleType.TV, AnimeTitleStatus.COMPLETED),
                new AnimeTitleDto("Bakemonogatari", "1", "/images/Bakemonogatari.jpg", AnimeTitleType.TV, AnimeTitleStatus.DROPPED),
                new AnimeTitleDto("Your Name", "8", "/images/KimiNoNaWa.jpg", AnimeTitleType.Movie, AnimeTitleStatus.COMPLETED),
                new AnimeTitleDto("Hikaru no Go", "10", "/images/HikaruNoGo.jpg", AnimeTitleType.TV, AnimeTitleStatus.COMPLETED),
                new AnimeTitleDto("Spy X Family", "", "/images/SpyXFamily.jpg", AnimeTitleType.TV, AnimeTitleStatus.PLANTOWATCH),
                new AnimeTitleDto("Naruto", "5", "/images/Naruto.jpg", AnimeTitleType.TV, AnimeTitleStatus.COMPLETED),
                new AnimeTitleDto("Bakemonogatari", "1", "/images/Bakemonogatari.jpg", AnimeTitleType.TV, AnimeTitleStatus.DROPPED),
                new AnimeTitleDto("Your Name", "8", "/images/KimiNoNaWa.jpg", AnimeTitleType.Movie, AnimeTitleStatus.COMPLETED),
                new AnimeTitleDto("Hikaru no Go", "10", "/images/HikaruNoGo.jpg", AnimeTitleType.TV, AnimeTitleStatus.COMPLETED),
                new AnimeTitleDto("Spy X Family", "", "/images/SpyXFamily.jpg", AnimeTitleType.TV, AnimeTitleStatus.PLANTOWATCH),
                new AnimeTitleDto("Naruto", "5", "/images/Naruto.jpg", AnimeTitleType.TV, AnimeTitleStatus.COMPLETED),
                new AnimeTitleDto("Bakemonogatari", "1", "/images/Bakemonogatari.jpg", AnimeTitleType.TV, AnimeTitleStatus.DROPPED),
                new AnimeTitleDto("Your Name", "8", "/images/KimiNoNaWa.jpg", AnimeTitleType.Movie, AnimeTitleStatus.COMPLETED),
                new AnimeTitleDto("Hikaru no Go", "10", "/images/HikaruNoGo.jpg", AnimeTitleType.TV, AnimeTitleStatus.COMPLETED),
                new AnimeTitleDto("Spy X Family", "", "/images/SpyXFamily.jpg", AnimeTitleType.TV, AnimeTitleStatus.PLANTOWATCH),
                new AnimeTitleDto("Naruto", "5", "/images/Naruto.jpg", AnimeTitleType.TV, AnimeTitleStatus.COMPLETED),
                new AnimeTitleDto("Bakemonogatari", "1", "/images/Bakemonogatari.jpg", AnimeTitleType.TV, AnimeTitleStatus.DROPPED),
                new AnimeTitleDto("Your Name", "8", "/images/KimiNoNaWa.jpg", AnimeTitleType.Movie, AnimeTitleStatus.COMPLETED),
                new AnimeTitleDto("Hikaru no Go", "10", "/images/HikaruNoGo.jpg", AnimeTitleType.TV, AnimeTitleStatus.COMPLETED),
                new AnimeTitleDto("Spy X Family", "", "/images/SpyXFamily.jpg", AnimeTitleType.TV, AnimeTitleStatus.PLANTOWATCH),
                new AnimeTitleDto("Naruto", "5", "/images/Naruto.jpg", AnimeTitleType.TV, AnimeTitleStatus.COMPLETED),
                new AnimeTitleDto("Bakemonogatari", "1", "/images/Bakemonogatari.jpg", AnimeTitleType.TV, AnimeTitleStatus.DROPPED),
                new AnimeTitleDto("Your Name", "8", "/images/KimiNoNaWa.jpg", AnimeTitleType.Movie, AnimeTitleStatus.COMPLETED),
                new AnimeTitleDto("Hikaru no Go", "10", "/images/HikaruNoGo.jpg", AnimeTitleType.TV, AnimeTitleStatus.COMPLETED),
                new AnimeTitleDto("Spy X Family", "", "/images/SpyXFamily.jpg", AnimeTitleType.TV, AnimeTitleStatus.PLANTOWATCH)
        );

        List<AnimeTitle> animeTitleList = new ArrayList<>();
        for(AnimeTitleDto animeTitleDto : animeTitleDtoList){
            AnimeTitle animeTitle = new AnimeTitle();
            animeTitle.setName(animeTitleDto.getName());
            animeTitle.setDescription(animeTitleDto.getDescription());
            animeTitle.setCoverUrl(animeTitleDto.getCoverUrl());
            animeTitle.setScore(animeTitleDto.getScore());
            animeTitle.setStatus(animeTitleDto.getStatus());
            animeTitle.setType(animeTitleDto.getType());
            animeTitleList.add(animeTitle);
        }
        animeTitleRepository.createList(animeTitleList);
    }
}
