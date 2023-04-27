package cz.jakvitov.jwtauthimpl.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class SecUser {

    @Id
    @Column(name = "user_name")
    private String userName;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_name"),
            inverseJoinColumns = @JoinColumn(name = "user_role_id"))
    private Set<UserRole> userRoles;


    public SecUser() {
    }

    public SecUser(String userName, String password, Set<UserRole> userRoles) {
        this.userName = userName;
        this.password = password;
        this.userRoles = userRoles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return "SecUser{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userRoles=" + userRoles +
                '}';
    }
}
