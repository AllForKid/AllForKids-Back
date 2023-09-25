package AFK.AFK.Settings.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class LinkedUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;
    private String name;
    private String address;
    private String working_hour;

}
