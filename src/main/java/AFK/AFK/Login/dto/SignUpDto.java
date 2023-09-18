package AFK.AFK.Login.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpDto {
    private Long userId;
    private String email;
    private String password;
    private String username;
}

