package AFK.AFK.Login.controller;

import AFK.AFK.Login.entity.User;
import AFK.AFK.Login.repository.*;
import AFK.AFK.Login.service.*;
import AFK.AFK.Settings.model.Ask;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final SignUpService signUpService;
    private final LoginService loginService;


    @GetMapping("/user/{id}")                // id 별로 get
    public ResponseEntity<User> getEntity(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/user")
    public User createEntity(@RequestBody User user) {
        return userRepository.save(user);
    }

    // 로그인
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) throws Exception {
        loginService.login(email, password);
        return "/api/user/main";
    }

//    TODO:
//     회원탈퇴
    @PostMapping("/delete")
    public String deleteUser(@RequestParam String email, @RequestParam String password) {
        // 이메일과 비밀번호로 사용자 인증
        User user = userRepository.findByEmailAndPassword(email, password);

        if (user != null) {
            // 사용자가 인증되었으므로 데이터베이스에서 삭제
            userRepository.delete(user);
            return "회원이 성공적으로 삭제되었습니다.";
        } else {
            return "이메일 또는 비밀번호가 일치하지 않습니다.";
        }
    }


    // 로그아웃
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session){
        if (session != null){
            //세션 무효화 (로그아웃)
            session.invalidate();
            return ResponseEntity.ok("로그아웃 되었습니다.");
        } else{
            return ResponseEntity.badRequest().body("로그인 상태가 아닙니다.");
        }
    }
}

