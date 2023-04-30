package cz.jakvitov.jwtauthimpl.persistence;

import cz.jakvitov.jwtauthimpl.entity.SecUser;
import cz.jakvitov.jwtauthimpl.entity.UserRole;
import cz.jakvitov.jwtauthimpl.security.UserRoleEnum;
import cz.jakvitov.jwtauthimpl.service.UserService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SetupDatabaseTestUsers {

    @Autowired
    UserService userService;

    private final String username = "user";
    private final String adminname = "admin";

    @Test
    @Disabled
    public void setupUsersInDatabase(){
        SecUser user = new SecUser();
        SecUser admin = new SecUser();

        user.setUserName(username);
        user.setPassword(username);

        admin.setUserName(adminname);
        admin.setPassword(adminname);

        UserRole userRole = new UserRole(UserRoleEnum.USER);
        UserRole adminRole = new UserRole(UserRoleEnum.ADMIN);

        user = userService.saveUser(user);
        admin = userService.saveUser(admin);

        userService.setNewRoleToUser(user, UserRoleEnum.USER);
        userService.setNewRoleToUser(admin, UserRoleEnum.ADMIN);
        userService.setNewRoleToUser(admin, UserRoleEnum.USER);
    }

    @Test
    @Disabled
    public void deleteTestUsers(){
        userService.deleteUserById(username);
        userService.deleteUserById(adminname);
    }

}
