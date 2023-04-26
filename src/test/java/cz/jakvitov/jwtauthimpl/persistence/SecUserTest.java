package cz.jakvitov.jwtauthimpl.persistence;

import cz.jakvitov.jwtauthimpl.entity.SecUser;
import cz.jakvitov.jwtauthimpl.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SecUserTest {

    @Autowired
    private UserService userService;

    @Test
    public void saveUser(){
        SecUser secUser = new SecUser();
        secUser.setUserName("test");
        secUser.setPassword("test");
        userService.saveUser(secUser);
    }

    @Test
    public void getAllUsers(){
        System.out.println(userService.findAllUsers().toString());
    }

    @Test
    public void deleteUser(){
        userService.deleteUserById("test");
    }

}
