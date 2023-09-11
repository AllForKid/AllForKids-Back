package AFK.AFK.Settings.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class MyTravel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String working_hour;
    @ElementCollection
    @CollectionTable(name = "travel_badges")
    private List<String> badges;
}
