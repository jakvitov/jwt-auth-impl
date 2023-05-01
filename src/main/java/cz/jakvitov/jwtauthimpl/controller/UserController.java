package cz.jakvitov.jwtauthimpl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/greet")
    public String greetUser(){
        return "Hello user";
    }

}
