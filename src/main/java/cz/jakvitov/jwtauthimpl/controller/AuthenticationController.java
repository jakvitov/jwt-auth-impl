package cz.jakvitov.jwtauthimpl.controller;

import cz.jakvitov.jwtauthimpl.security.model.AuthenticationRequestDto;
import cz.jakvitov.jwtauthimpl.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping("/auth")
    public ResponseEntity<String> loginConntroller(@RequestBody AuthenticationRequestDto authenticationRequestDto){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequestDto.getUserName(), authenticationRequestDto.getPassword()));
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequestDto.getUserName());
        return ResponseEntity.ok(jwtService.generateToken(userDetails));
    }

}
