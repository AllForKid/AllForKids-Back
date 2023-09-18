package AFK.AFK.Login.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private String accessToken;
    private String refreshToken;

    public Token(User user, String accessToken, String refreshToken) {
        this.user = user;
        this.refreshToken = refreshToken;
    }

}

