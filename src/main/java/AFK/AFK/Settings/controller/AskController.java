package AFK.AFK.Settings.controller;

import AFK.AFK.Settings.repository.AskRepository;
import AFK.AFK.Settings.model.Ask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/settings/user")
public class AskController {
    @Autowired
    private AskRepository askRepository;

    @GetMapping("/ask/{id}")                // id 별로 get
    public ResponseEntity<Ask> getEntity(@PathVariable Long id) {
    Optional<Ask> ask = askRepository.findById(id);
    if (ask.isPresent()) {
        return ResponseEntity.ok(ask.get());
    } else {
        return ResponseEntity.notFound().build();
    }
}
    @PostMapping("/ask")
    public Ask createEntity(@RequestBody Ask ask) {
        return askRepository.save(ask);
    }
}
