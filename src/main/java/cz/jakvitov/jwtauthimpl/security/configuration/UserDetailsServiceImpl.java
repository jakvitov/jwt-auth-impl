package cz.jakvitov.jwtauthimpl.security.configuration;

import cz.jakvitov.jwtauthimpl.entity.SecUser;
import cz.jakvitov.jwtauthimpl.security.model.UserDetailsImpl;
import cz.jakvitov.jwtauthimpl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecUser secUser = userService.getUserByUserName(username);
        return new UserDetailsImpl(secUser);
    }
}
