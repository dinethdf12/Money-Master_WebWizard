package com.moneyMaster.Money_Master_WebWizard.controller;

import com.moneyMaster.Money_Master_WebWizard.model.CurrentUser;
import com.moneyMaster.Money_Master_WebWizard.security.jwt.JwtUtil;
import com.moneyMaster.Money_Master_WebWizard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    @GetMapping
    public ResponseEntity<List<CurrentUser>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CurrentUser> getUser(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(id));
    }

    @PostMapping("/register")
    public ResponseEntity<CurrentUser> saveUser(@RequestBody CurrentUser user){
        return ResponseEntity.status(HttpStatus.OK).body(userService.saveUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> logUser(@RequestBody CurrentUser user){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                user.getUsername(),
                user.getPassword()
        );

        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwtToken = JwtUtil.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(jwtToken);

    }
}
