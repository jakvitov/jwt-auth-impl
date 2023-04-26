package cz.jakvitov.jwtauthimpl.service;

import cz.jakvitov.jwtauthimpl.entity.SecUser;
import cz.jakvitov.jwtauthimpl.security.UserRoleEnum;

import java.util.List;

public interface UserService {

    public SecUser saveUser(SecUser secUser);

    public void deleteUserById(String userName);

    public List<SecUser> findAllUsers();

    public SecUser getUserByUserName(String name);

    public SecUser setNewRoleToUser(SecUser secUser,UserRoleEnum userRoleEnum);
}
