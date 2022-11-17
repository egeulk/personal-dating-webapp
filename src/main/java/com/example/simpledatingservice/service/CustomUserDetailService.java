package com.example.simpledatingservice.service;

import com.example.simpledatingservice.entities.UsersLogin;
import com.example.simpledatingservice.entities.UsersLoginPrincipal;
import com.example.simpledatingservice.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private UserLoginRepository userLoginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersLogin usersLogin = userLoginRepository.findByEmail(username);
        if (usersLogin == null) {
            throw new UsernameNotFoundException(username);
        }
        UsersLoginPrincipal principal = new UsersLoginPrincipal();
        principal.setUserslogin(usersLogin);
        return principal;
    }

    @Autowired
    public void setUserLoginRepository(UserLoginRepository userLoginRepository) {
        this.userLoginRepository = userLoginRepository;
    }
}
