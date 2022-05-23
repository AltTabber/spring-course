package net.alttabber.myanimelistclone.repository;

import net.alttabber.myanimelistclone.entities.AnimeTitle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AnimeTitleRepository {

    @PersistenceContext
    EntityManager em;

    public void createList(List<AnimeTitle> animeTitleList){
        animeTitleList.stream().forEach(animeTitle -> {
            em.persist(animeTitle);
        });
    }

    public List<AnimeTitle> getAll(){
        return em.createNativeQuery("SELECT * FROM anime_title", AnimeTitle.class).getResultList();
    }

    public AnimeTitle update(AnimeTitle animeTitle){
        return em.merge(animeTitle);
    }

}
