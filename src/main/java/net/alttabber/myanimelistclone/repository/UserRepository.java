package net.alttabber.myanimelistclone.repository;

import net.alttabber.myanimelistclone.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
