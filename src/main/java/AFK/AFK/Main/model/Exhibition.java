package AFK.AFK.Main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exhibition {
    private Long id;
    private String name;
    private String imageUrl;
    private String description;
}