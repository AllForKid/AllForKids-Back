package AFK.AFK.Login.repository;


import AFK.AFK.Login.entity.User;
import lombok.Data;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    //extends JpaRepository<SecurityProperties.User, Long>
    User findByEmailAndPassword(String email, String password);
}

