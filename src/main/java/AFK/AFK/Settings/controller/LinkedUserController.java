package AFK.AFK.Settings.controller;

import AFK.AFK.Settings.model.Ask;
import AFK.AFK.Settings.model.LinkedUser;
import AFK.AFK.Settings.repository.AskRepository;
import AFK.AFK.Settings.repository.LinkedUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/settings/user")
public class LinkedUserController {
    @Autowired
    private LinkedUserRepository linkedUserRepository;

    // get해온 코드로 정보 가져오기
    @GetMapping("/linked-account/{id}")
    public ResponseEntity<LinkedUser> getEntity(@PathVariable Long id) {
        Optional<LinkedUser> linkedUser = linkedUserRepository.findById(id);
        if (linkedUser.isPresent()) {
            return ResponseEntity.ok(linkedUser.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
