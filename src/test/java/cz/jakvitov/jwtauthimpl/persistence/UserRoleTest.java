package cz.jakvitov.jwtauthimpl.persistence;

import cz.jakvitov.jwtauthimpl.entity.SecUser;
import cz.jakvitov.jwtauthimpl.entity.UserRole;
import cz.jakvitov.jwtauthimpl.security.UserRoleEnum;
import cz.jakvitov.jwtauthimpl.service.UserRoleRepository;
import cz.jakvitov.jwtauthimpl.service.UserService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UserRoleTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Test
    @Disabled
    public void addUserRoleToUser(){
        SecUser secUser = userService.getUserByUserName("test");

        userService.setNewRoleToUser(secUser, UserRoleEnum.USER);

        System.out.println(userService.getUserByUserName("test").getUserRoles());
    }

    @Test
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    @Disabled
    public void getAllRolesUsers(){
        Optional<UserRole> userRole = userRoleRepository.findById(UserRoleEnum.USER.getTextValue());
        userRole.orElseThrow(() -> new RuntimeException("Role user not found."));
        UserRole userRole1 = userRole.get();
        System.out.println(userRole1.getRoleUsers());
    }


}
