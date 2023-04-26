package cz.jakvitov.jwtauthimpl.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration {

    //Only for development and testing we do not encode passwords
    @Bean
    public PasswordEncoder setUpPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
