package AFK.AFK.Map.repository;

import AFK.AFK.Map.model.MyTravel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyTravelRepository extends JpaRepository<MyTravel, Long> {
    List<MyTravel> findAll();
}
