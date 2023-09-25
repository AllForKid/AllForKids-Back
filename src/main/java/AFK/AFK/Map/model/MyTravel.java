package AFK.AFK.Map.model;

import AFK.AFK.Settings.model.Badge;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class MyTravel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String place_name;
    private String address;
    private String working_hour;

//    @OneToMany(mappedBy = "myTravel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Badge> badges = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "badge_id")
    private Badge badge;
}
