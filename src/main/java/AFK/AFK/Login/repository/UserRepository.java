package AFK.AFK.Login.repository;

import AFK.AFK.Login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
