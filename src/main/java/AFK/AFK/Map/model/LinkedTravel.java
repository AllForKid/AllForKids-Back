package AFK.AFK.Map.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class LinkedTravel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String place_name;

    private String linked_name;
    private String address;
    private String working_hour;
    @ElementCollection
    @CollectionTable(name = "travel_badges")
    private List<String> badges;
}
