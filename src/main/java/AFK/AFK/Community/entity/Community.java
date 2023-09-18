package AFK.AFK.Community.entity;

import AFK.AFK.Login.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.rmi.registry.LocateRegistry;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Getter

public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId = null;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private String type;
    private String title;
    private String content;
    private String writer;
    private boolean isAnonymous;
    private String imageUrl;
    private LocalDate createdAt;

    public Community(User user, String type, String title, String content, String writer, boolean isAnonymous, String imageUrl) {
        this.user = user;
        this.type = type;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.isAnonymous = isAnonymous;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
    }
    public void updateCommunity(String title, String content, String imageUrl) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
    }
}