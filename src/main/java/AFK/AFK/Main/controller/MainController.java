package AFK.AFK.Main.controller;

import AFK.AFK.Main.model.Exhibition;
import AFK.AFK.Main.service.ExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/main/")
public class MainController {

    @Autowired
    private ExhibitionService exhibitionService;

    @GetMapping("/recommended-exhibitions")
    public ResponseEntity<List<Exhibition>> getRecommendedExhibitions() {
        List<Exhibition> exhibitions = exhibitionService.getRecommendedExhibitions();
        return ResponseEntity.ok(exhibitions);
    }

    @GetMapping("/family-trip-courses")
    public ResponseEntity<List<Exhibition>> getFamilyTripCourses() {
        List<Exhibition> exhibitions = exhibitionService.getFamilyTripCourses();
        return ResponseEntity.ok(exhibitions);
    }

    @GetMapping("/theme-travel-recommendations")
    public ResponseEntity<List<Exhibition>> getThemeTravelRecommendations() {
        List<Exhibition> exhibitions = exhibitionService.getThemeTravelRecommendations();
        return ResponseEntity.ok(exhibitions);
    }

    @GetMapping("/my-favorite-places")
    public ResponseEntity<List<Exhibition>> getMyFavoritePlaces() {
        List<Exhibition> exhibitions = exhibitionService.getMyFavoritePlaces();
        return ResponseEntity.ok(exhibitions);
    }

    @GetMapping("/tag-travel-recommendations")
    public ResponseEntity<List<Exhibition>> getTagTravelRecommendations() {
        List<Exhibition> exhibitions = exhibitionService.getTagTravelRecommendations();
        return ResponseEntity.ok(exhibitions);
    }
}

