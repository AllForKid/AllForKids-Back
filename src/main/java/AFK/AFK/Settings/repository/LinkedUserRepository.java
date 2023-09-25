package AFK.AFK.Settings.repository;

import AFK.AFK.Settings.model.Ask;
import AFK.AFK.Settings.model.LinkedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkedUserRepository extends JpaRepository<LinkedUser, Long> {
}
