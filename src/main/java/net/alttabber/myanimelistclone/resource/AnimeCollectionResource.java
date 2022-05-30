package net.alttabber.myanimelistclone.resource;

import net.alttabber.myanimelistclone.data.AnimeTitleDto;
import net.alttabber.myanimelistclone.data.AnimeTitleStatus;
import net.alttabber.myanimelistclone.data.AnimeTitleType;
import net.alttabber.myanimelistclone.entities.AnimeTitle;
import net.alttabber.myanimelistclone.entities.AnimeTitleEntry;
import net.alttabber.myanimelistclone.entities.Image;
import net.alttabber.myanimelistclone.entities.User;
import net.alttabber.myanimelistclone.repository.AnimeTitleEntryRepository;
import net.alttabber.myanimelistclone.repository.AnimeTitleRepository;
import net.alttabber.myanimelistclone.repository.ImageRepository;
import net.alttabber.myanimelistclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class AnimeCollectionResource {

    AnimeTitleRepository animeTitleRepository;
    UserRepository userRepository;
    ImageRepository imageRepository;
    AnimeTitleEntryRepository animeTitleEntryRepository;

    public AnimeCollectionResource(AnimeTitleRepository animeTitleRepository, UserRepository userRepository,
                                   ImageRepository imageRepository, AnimeTitleEntryRepository animeTitleEntryRepository) {
        this.animeTitleRepository = animeTitleRepository;
        this.userRepository = userRepository;
        this.imageRepository = imageRepository;
        this.animeTitleEntryRepository = animeTitleEntryRepository;
    }

    @Autowired


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
        List<AnimeTitle> animeTitleList = animeTitleRepository.findAll();
        for(AnimeTitle animeTitle : animeTitleList){

            AnimeTitleDto animeTitleDto = new AnimeTitleDto();
            animeTitleDto.setId(animeTitle.getId());
            animeTitleDto.setName(animeTitle.getName());
            animeTitleDto.setDescription(animeTitle.getDescription());
            animeTitleDto.setCoverUrl(animeTitle.getImage().getUrl());
            animeTitleDto.setScore(animeTitle.getScore());
            animeTitleDto.setType(animeTitle.getType());

            outputAnimeTitleDtoList.add(animeTitleDto);
        }

        return outputAnimeTitleDtoList;
    }

    public List<AnimeTitleDto> getAnimeTitleCollection(Long userId){
        List<AnimeTitleEntry> animeTitleEntries = animeTitleEntryRepository.findByUserId(userId);
        List<AnimeTitleDto> outputAnimeTitleDtoList = new ArrayList<>();

        animeTitleEntries.forEach(animeTitleEntry -> {
            AnimeTitleDto animeTitleDto = new AnimeTitleDto();
            animeTitleDto.setId(animeTitleEntry.getAnimeTitle().getId());
            animeTitleDto.setName(animeTitleEntry.getAnimeTitle().getName());
            animeTitleDto.setDescription(animeTitleEntry.getAnimeTitle().getDescription());
            animeTitleDto.setCoverUrl(animeTitleEntry.getAnimeTitle().getImage().getUrl());
            animeTitleDto.setScore(animeTitleEntry.getScore());
            animeTitleDto.setType(animeTitleEntry.getAnimeTitle().getType());
            animeTitleDto.setStatus(animeTitleEntry.getStatus());

            outputAnimeTitleDtoList.add(animeTitleDto);
        });

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

        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUsername("AltTabber");
        user1.setPassword("Qwerty123");
        user1.setCreateDate(LocalDateTime.now());
        users.add(user1);

        user1 = new User();
        user1.setUsername("noname");
        user1.setPassword("14147a593295fbfb63d2a9c267e98f6e");
        user1.setCreateDate(LocalDateTime.now());
        users.add(user1);

        user1 = new User();
        user1.setUsername("SirKus");
        user1.setPassword("Qwerty123");
        user1.setCreateDate(LocalDateTime.now());
        users.add(user1);

        user1 = new User();
        user1.setUsername("baton");
        user1.setPassword("qwerty4321");
        user1.setCreateDate(LocalDateTime.now());
        users.add(user1);

        user1 = new User();
        user1.setUsername("inferno");
        user1.setPassword("Qwerty123");
        user1.setCreateDate(LocalDateTime.now());
        users.add(user1);

        user1 = new User();
        user1.setUsername("Neimzi");
        user1.setPassword("Qwerty123");
        user1.setCreateDate(LocalDateTime.now());
        users.add(user1);

        if(!(userRepository.count() >= users.size())){
            users = userRepository.saveAll(users);
        }else{
            users = userRepository.findAll();
        }

        List<AnimeTitle> animeTitleList = new ArrayList<>();
        animeTitleList.add(createAnimeTitle("Naruto", AnimeTitleType.TV, "Anime about ninjas",
                "0", "/images/Naruto.jpg"));
        animeTitleList.add(createAnimeTitle("Bakemonogatari", AnimeTitleType.TV, "Anime about psychos",
                "0", "/images/Bakemonogatari.jpg"));
        animeTitleList.add(createAnimeTitle("Your Name", AnimeTitleType.Movie, "Anime about love",
                "0", "/images/KimiNoNaWa.jpg"));
        animeTitleList.add(createAnimeTitle("Hikaru no Go", AnimeTitleType.TV, "Anime about go",
                "0", "/images/HikaruNoGo.jpg"));
        animeTitleList.add(createAnimeTitle("Spy X Family", AnimeTitleType.TV, "Anime about family",
                "0", "/images/SpyXFamily.jpg"));

        if(!(animeTitleRepository.count() >= animeTitleList.size() )){
            animeTitleList = animeTitleRepository.saveAll(animeTitleList);
        }else{
            animeTitleList = animeTitleRepository.findAll();
        }




        Random rand = new Random();
        List<User> finalUsers = users;
        List<Image> images = new ArrayList<>();
        animeTitleDtoList.forEach(animeTitleDto -> {
            AnimeTitleEntry animeTitleEntry = new AnimeTitleEntry();
            animeTitleEntry.setAnimeTitle(animeTitleRepository.findByName(animeTitleDto.getName()));
            animeTitleEntry.setScore(animeTitleDto.getScore());
            animeTitleEntry.setUser(finalUsers.get(rand.nextInt(finalUsers.size())));
            animeTitleEntry.setStatus(animeTitleDto.getStatus());
            animeTitleEntryRepository.save(animeTitleEntry);
        });
    }

    private AnimeTitle createAnimeTitle(String name, AnimeTitleType type, String description, String score, String coverUrl) {
        AnimeTitle animeTitle = new AnimeTitle();
        animeTitle.setName(name);
        animeTitle.setType(type);
        animeTitle.setDescription(description);
        Image image = new Image(coverUrl);
        image = imageRepository.save(image);
        animeTitle.setImage(image);
        animeTitle.setScore(score);
        return animeTitle;
    }

}
