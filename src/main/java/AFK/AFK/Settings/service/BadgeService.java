package AFK.AFK.Settings.service;

import AFK.AFK.Settings.model.Badge;
import AFK.AFK.Settings.repository.BadgeRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BadgeService {
    @Autowired
    private BadgeRepository badgeRepository;

    public Badge createBadge(String[] travel_badge) {
        Badge badge = new Badge();
        badge.setTravel_badge(new Gson().toJson(travel_badge));
        return badgeRepository.save(badge);
    }

    public Badge getBadge(Long id) {
        Optional<Badge> badgeOptional = badgeRepository.findById(id);
        return badgeOptional.orElse(null);
    }

    public void deleteBadge(Long id) {
        badgeRepository.deleteById(id);
    }

    public Badge updateBadge(Long id, String[] travel_badge) {
        Badge existingBadge = badgeRepository.findById(id).orElse(null);
        if (existingBadge != null) {
            existingBadge.setTravel_badge(new Gson().toJson(travel_badge));
            return badgeRepository.save(existingBadge);
        } else {
            return null;
        }
    }
}
