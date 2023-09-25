package AFK.AFK.Map.repository;

import AFK.AFK.Map.model.MyTravel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkedTravelRepository extends JpaRepository<MyTravel, Long> {
}
