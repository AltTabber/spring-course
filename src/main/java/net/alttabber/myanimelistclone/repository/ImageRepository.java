package net.alttabber.myanimelistclone.repository;

import net.alttabber.myanimelistclone.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    Image findByUrl(String url);

}
