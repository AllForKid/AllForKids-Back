package AFK.AFK.Login.repository;


import AFK.AFK.Login.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
}
