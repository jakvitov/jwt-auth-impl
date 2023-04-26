package cz.jakvitov.jwtauthimpl.security.model;

import cz.jakvitov.jwtauthimpl.entity.SecUser;
import cz.jakvitov.jwtauthimpl.entity.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserDetailsImpl implements UserDetails {

    private String userName;
    private String password;

    private Set<UserRole> userRoles;

    public UserDetailsImpl(SecUser secUser){
        this.userName = secUser.getUserName();
        this.password = secUser.getPassword();
        this.userRoles = secUser.getUserRoles();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        for (UserRole userRole : userRoles){
            grantedAuthoritySet.add(new SimpleGrantedAuthority(userRole.getRoleText()));
        }
        return grantedAuthoritySet;
    }

    @Override
    public String getPassword() {
        return this.getPassword();
    }

    @Override
    public String getUsername() {
        return this.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
