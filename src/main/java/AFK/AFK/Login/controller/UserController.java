package AFK.AFK.Login.controller;

import AFK.AFK.Login.model.User;
import AFK.AFK.Login.repository.UserRepository;
import AFK.AFK.Settings.model.Ask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login/{id}")                // id 별로 get
    public ResponseEntity<User> getEntity(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
//    @DeleteMapping("/delete/{id}")
//    public String deleteUser(@PathVariable Long id) {
//        userRepository.deleteById(id);
//        return "회원이 성공적으로 삭제되었습니다.";
//    }
    }
}
