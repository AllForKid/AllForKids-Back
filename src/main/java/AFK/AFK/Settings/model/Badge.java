package AFK.AFK.Settings.model;

import AFK.AFK.Settings.converter.BadgeConverter;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "json")
    private String travel_badge;

}
