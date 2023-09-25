package AFK.AFK.Login.service;

import AFK.AFK.Login.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //회원탈퇴 처리
    public void deleteUser(String email, String password) throws Exception{

    }
}
