package com.example.simpledatingservice.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UsersLoginPrincipal implements UserDetails {
    private UsersLogin userslogin;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
                 return null;
    }

    public UsersLoginPrincipal(UsersLogin userslogin) {
        this.userslogin = userslogin;
    }

    @Override
    public String getPassword() {
        return userslogin.getPassword();
    }

    @Override
    public String getUsername() {
        return userslogin.getEmail();
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

    public UsersLogin getUserslogin() {
        return userslogin;
    }

    public void setUserslogin(UsersLogin userslogin) {
        this.userslogin = userslogin;
    }

}
