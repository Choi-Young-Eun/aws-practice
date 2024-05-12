package com.choiye.awspractice.controller;

import com.choiye.awspractice.dto.UserSignupDto;
import com.choiye.awspractice.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/hello")
    public ResponseEntity helloTest(){
        return ResponseEntity.ok("Hello! Congratulations :)");
    }

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody @Valid UserSignupDto signupDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(signupDto));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestParam @Email String email, @RequestParam String password) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.loginUser(email, password));
    }

    @DeleteMapping("/logout")
    public ResponseEntity logout(@RequestParam @Email String email){
        if(userService.logoutUser(email))
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/information")
    public ResponseEntity getUserInformation(@RequestParam @Email String email) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(email));
    }


}
