package AFK.AFK.Settings.model;

import AFK.AFK.Map.model.MyTravel;
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

//    @ManyToOne
//    @JoinColumn(name = "my_travel_id")
//    private MyTravel myTravel;
}
