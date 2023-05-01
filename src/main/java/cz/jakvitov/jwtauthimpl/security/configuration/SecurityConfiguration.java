package cz.jakvitov.jwtauthimpl.security.configuration;

import cz.jakvitov.jwtauthimpl.entity.UserRole;
import cz.jakvitov.jwtauthimpl.security.UserRoleEnum;
import cz.jakvitov.jwtauthimpl.security.filters.JwtAuthFilter;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    @Autowired
    JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                //Dev. only disabled csrf to allow postman requests
                .csrf().disable()
                .authorizeHttpRequests((request) -> request
                        .requestMatchers("/admin/**").hasAuthority(UserRoleEnum.ADMIN.getTextValue())
                        .requestMatchers("/user/**").hasAnyAuthority(UserRoleEnum.USER.getTextValue(), UserRoleEnum.ADMIN.getTextValue())
                        .requestMatchers(HttpMethod.POST, "/auth").permitAll()
                );
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authManagerSetupBean(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    //Only for development and testing we do not encode passwords
    @Bean
    public PasswordEncoder setUpPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
