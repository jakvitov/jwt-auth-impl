package cz.jakvitov.jwtauthimpl.entity;

import cz.jakvitov.jwtauthimpl.security.UserRoleEnum;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class UserRole {

    @Id
    private String roleText;

    @ManyToMany(mappedBy = "userRoles")
    private Set<SecUser> roleSecUsers;

    public UserRole() {
    }

    public UserRole(UserRoleEnum userRoleEnum, Set<SecUser> roleSecUsers) {
        this.roleText = userRoleEnum.getTextValue();
        this.roleSecUsers = roleSecUsers;
    }

    public UserRole(UserRoleEnum userRoleEnum){
        this.roleText = userRoleEnum.getTextValue();
    }

    public String getRoleText() {
        return roleText;
    }

    public void setRoleText(String roleText) {
        this.roleText = roleText;
    }

    public Set<SecUser> getRoleUsers() {
        return roleSecUsers;
    }

    public void setRoleUsers(Set<SecUser> roleSecUsers) {
        this.roleSecUsers = roleSecUsers;
    }
}
