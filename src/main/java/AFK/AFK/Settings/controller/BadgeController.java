package AFK.AFK.Settings.controller;

import AFK.AFK.Settings.model.Badge;
import AFK.AFK.Settings.repository.BadgeRepository;
import AFK.AFK.Settings.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/settings/user")
public class BadgeController {

    @Autowired
    private BadgeService badgeService;

    @GetMapping("/badge/{id}")
    public ResponseEntity<Badge> getBadge(@PathVariable Long id) {
        Badge badge = badgeService.getBadge(id);
        if (badge != null) {
            return new ResponseEntity<>(badge, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/badge")
    public ResponseEntity<Badge> createBadge(@RequestBody Map<String, List<String>> request) {
        List<String> travel_badge = request.get("travel_badge");
        Badge badge = badgeService.createBadge(travel_badge.toArray(new String[0]));
        return new ResponseEntity<>(badge, HttpStatus.CREATED);
    }
    @PutMapping("/badge/{id}")
    public ResponseEntity<Badge> updateBadge(@PathVariable Long id, @RequestBody Map<String, List<String>> request) {
        List<String> travel_badge = request.get("travel_badge");
        Badge updatedBadge = badgeService.updateBadge(id, travel_badge.toArray(new String[0]));
        if (updatedBadge != null) {
            return new ResponseEntity<>(updatedBadge, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/badge/{id}")
    public ResponseEntity<Badge> deleteBadge(@PathVariable Long id) {
        badgeService.deleteBadge(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
