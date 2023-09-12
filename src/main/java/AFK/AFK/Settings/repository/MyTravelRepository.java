package AFK.AFK.Settings.repository;

import AFK.AFK.Settings.model.MyTravel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyTravelRepository extends JpaRepository<MyTravel, Long> {
}
