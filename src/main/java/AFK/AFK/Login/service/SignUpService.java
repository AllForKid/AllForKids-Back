package AFK.AFK.Login.service;

import AFK.AFK.Login.repository.*;
import AFK.AFK.Login.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
    private SignUpDto signUpDto;
    private SignUpRepository signUpRepository;

    @Autowired
    public SignUpService(SignUpRepository SignUpRepository){
        this.signUpRepository = signUpRepository;
        this.signUpRepository = signUpRepository;
    }
    public void signup(SignUpDto signUpRequestDto) throws Exception{
        if (this.signUpRepository.findByEmail(signUpRequestDto.getEmail()).isPresent()){
            throw new Exception("이미 존재하는 이메일입니다.");
        }
        if (this.signUpRepository.findByUsername(signUpRequestDto.getUsername()).isPresent()){
            throw new Exception("이미 존재하는 닉네임입니다.");
        }
    }
}
