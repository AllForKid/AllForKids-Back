package AFK.AFK.Settings.repository;

import AFK.AFK.Settings.model.Ask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AskRepository extends JpaRepository<Ask, Long> {
}
