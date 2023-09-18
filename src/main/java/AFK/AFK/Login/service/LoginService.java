package AFK.AFK.Login.service;


import AFK.AFK.Login.repository.*;
import AFK.AFK.Login.entity.*;
import AFK.AFK.Login.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    private LoginRepository loginRepository;
    private TokenRepository tokenRepository;


    @Autowired
    public LoginService(LoginRepository loginRepository, TokenRepository tokenRepository) {
        this.loginRepository = loginRepository;
        this.tokenRepository = tokenRepository;
    }

    public LoginResponseDto login(String email, String password) {
        try {
            Optional<User> user = loginRepository.findByEmail(email);
            Optional<User> user1 = loginRepository.findByPassword(password);
            if (user == user1) {
                tokenRepository.save(new Token(user.get(), "asdf", "lkjh"));
                return new LoginResponseDto(true, 1003, "로그인 성공");
            }
        } catch (Exception e) {
            System.out.println(e);
            return new LoginResponseDto(false, 3002, "로그인 실패");
        }
        return null;
    }
}
