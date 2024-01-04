package com.Revpay.FavePay.controllers;

import com.Revpay.FavePay.dto.NewUserDto;
import com.Revpay.FavePay.entities.Auth;
import com.Revpay.FavePay.entities.User;
import com.Revpay.FavePay.exceptions.AccessDeniedException;
import com.Revpay.FavePay.exceptions.UsernameUnavailableException;
import com.Revpay.FavePay.services.AuthService;
import com.Revpay.FavePay.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", allowCredentials = "true")
@RequestMapping("auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @Autowired
    public AuthController(AuthService authService, UserService userService){
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    @ResponseStatus(HttpStatus.OK)
    Auth registerNewUser (@RequestBody NewUserDto dto){
        Auth auth = dto.getAuth();
        User user = dto.getUser();
        userService.saveUser(user);
//        System.out.println("do work "+ user.toString());
        return authService.registerUser(auth);
    }

    @PostMapping(path = "/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Optional<User> authenticate(@RequestBody Auth auth, HttpServletResponse response) throws AccessDeniedException {
        System.out.println(auth.getUsername() + auth.getPassword());
        if(this.authService.authenticate(auth)){
            Cookie cookie = new Cookie("username", auth.getUsername());
            cookie.setMaxAge(60*60*24*7);
            cookie.setPath("/");
            response.addCookie(cookie);
            return userService.getUsername(auth.getUsername());
        } else {
            throw new AccessDeniedException("Access denied");
        }
    }


//    @ResponseStatus(HttpStatus.OK)
//    Auth loginUser (@RequestBody NewUserDto dto){
//        Auth auth = dto.getAuth();
//        User user = dto.getUser();
//        userService.saveUser(user);
////        System.out.println("do work "+ user.toString());
//        return authService.loginUser(auth);
//    }

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody Auth userLoginRequest) {
//
//        String username = userLoginRequest.getUsername();
//        String password = userLoginRequest.getPassword();
//
//        if (userService.getUsername(username).isPresent()) {
//            return ResponseEntity.ok("Login Successful!");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed. User not found.");
//        }
//    }

    @GetMapping(path = "/cookie-test")
    @ResponseStatus(HttpStatus.OK)
    public User testCookie(@CookieValue(name = "username") String username) {//get cookie from request
        System.out.println("cookie username: " + username);
        return new User();
    }

    @ExceptionHandler(UsernameUnavailableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String usernameUnavailableExceptionHandler() {
        return "This username is unavailable";
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String accessDeniedExceptionHandler() {
        return "Access denied";
    }


}
