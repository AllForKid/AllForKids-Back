package AFK.AFK.Settings.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "json")
    private String travel_badge;

}
