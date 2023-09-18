package AFK.AFK.Login.entity;

import jakarta.persistence.*;
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String username;
    private String email;
    private String password;
    private String role;



}