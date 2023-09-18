package AFK.AFK.Login.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponseDto {
    private boolean isSuccess;
    private int code;
    private String message;
}

