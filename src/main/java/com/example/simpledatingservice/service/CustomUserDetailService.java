package com.example.simpledatingservice.service;

import com.example.simpledatingservice.DTO.UserCredentialDTO;
import com.example.simpledatingservice.entities.UsersLogin;
import com.example.simpledatingservice.entities.UsersLoginPrincipal;
import com.example.simpledatingservice.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private UserLoginRepository userLoginRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public UsersLoginPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersLogin usersLogin = userLoginRepository.findByEmail(username);
        if (usersLogin == null) {
            throw new UsernameNotFoundException(username);
        }
        UsersLoginPrincipal principal = new UsersLoginPrincipal(usersLogin);
        return principal;
    }

    public void createNewUser(UserCredentialDTO userCredentials){
        String email = userCredentials.getEmail();
        String password = userCredentials.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        UsersLogin usersLogin = new UsersLogin(email, encodedPassword);
        userLoginRepository.save(usersLogin);
    }

    @Autowired
    public void setUserLoginRepository(UserLoginRepository userLoginRepository) {
        this.userLoginRepository = userLoginRepository;
    }
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
