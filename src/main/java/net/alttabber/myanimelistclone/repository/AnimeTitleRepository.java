package net.alttabber.myanimelistclone.repository;

import net.alttabber.myanimelistclone.entities.AnimeTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AnimeTitleRepository extends JpaRepository<AnimeTitle, Long> {

    AnimeTitle findByName(String name);

}
