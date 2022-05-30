package net.alttabber.myanimelistclone.repository;

import net.alttabber.myanimelistclone.entities.AnimeTitleEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeTitleEntryRepository extends JpaRepository<AnimeTitleEntry, Long> {

    List<AnimeTitleEntry> findByUserId(Long userId);

}
