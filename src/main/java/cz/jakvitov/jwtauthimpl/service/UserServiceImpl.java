package cz.jakvitov.jwtauthimpl.service;

import cz.jakvitov.jwtauthimpl.entity.SecUser;
import cz.jakvitov.jwtauthimpl.entity.UserRole;
import cz.jakvitov.jwtauthimpl.security.UserRoleEnum;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired UserRoleRepository userRoleRepository;

    @Override
    public SecUser saveUser(SecUser secUser) {
        return userRepository.save(secUser);
    }

    @Override
    public void deleteUserById(String userName) {
        userRepository.deleteById(userName);
    }

    @Override
    public List<SecUser> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public SecUser getUserByUserName(String name) {
        Optional<SecUser> optionalUser =  userRepository.findById(name);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("User " + name + " not found"));
        return optionalUser.get();
    }

    @Override
    @Transactional
    public SecUser setNewRoleToUser(SecUser secUser, UserRoleEnum userRoleEnum) {
        Optional<UserRole> optionalUserRole = userRoleRepository.findById(userRoleEnum.getTextValue());
        UserRole userRole;
        if (optionalUserRole.isEmpty()){
                userRole = new UserRole(userRoleEnum);
                userRoleRepository.save(userRole);
        }
        else {
            userRole = optionalUserRole.get();
        }
        if (secUser.getUserRoles() == null){
            Set<UserRole> userRoleSet = new HashSet<>();
            secUser.setUserRoles(userRoleSet);
        }
        secUser.getUserRoles().add(userRole);
        return userRepository.save(secUser);
    }
}
