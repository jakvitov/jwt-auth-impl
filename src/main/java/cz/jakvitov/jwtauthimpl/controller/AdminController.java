package cz.jakvitov.jwtauthimpl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/admin/greet")
    public String greetAdmin(){
        return "Hello admin";
    }

}
