package com.Revpay.FavePay.services;

import com.Revpay.FavePay.entities.Auth;
import com.Revpay.FavePay.repositories.AuthRepository;
import jakarta.transaction.Transactional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@Service
public class AuthService {
    //private UserService userService;
    private AuthRepository authRepository;
    private AccountService accountService;

    @Autowired
    public AuthService(AuthRepository authRepository, AccountService accountService) {
        //this.userService = userService;
        this.authRepository = authRepository;
        this.accountService = accountService;
    }


    @Transactional
    public Auth registerUser(Auth newUser) {//throws UsernameUnavailableException
            this.accountService.create(newUser);
            return this.authRepository.save(newUser);
//        if(!this.userService.checkUsername(newUser.getUser().getUsername())) {
//            newUser.getAuth().setPassword(this.hash(newUser.getAuth().getPassword()));
//            this.authRepository.save(newUser.getAuth());
//            return this.userService.saveOrUpdate(newUser.getUser());
//        }
//        throw new UsernameUnavailableException("This username is not available");


    }

    public Auth loginUser(Auth auth) {
        return this.authRepository.save(auth);
    }

    public boolean authenticate(Auth auth) {
        System.out.println(auth.getUsername() + auth.getPassword());
        Optional<Auth> candidate = this.authRepository.findByUsername(auth.getUsername());
        if(candidate.isPresent()) {
            System.out.println(candidate.toString());
//            return this.checkHash(auth.getPassword(), candidate.get().getPassword());
            return candidate.get().getPassword().equals(auth.getPassword()) ;
        } else {
            return false;
        }
    }

    public String hash(String text) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(text, salt);
    }

    public boolean checkHash(String text, String hash) {
        return BCrypt.checkpw(text, hash);
    }

}
