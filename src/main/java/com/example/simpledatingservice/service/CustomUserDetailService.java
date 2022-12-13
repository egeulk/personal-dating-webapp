package com.example.simpledatingservice.service;

import com.example.simpledatingservice.DTO.UserCredentialDTO;
import com.example.simpledatingservice.entities.UsersLogin;
import com.example.simpledatingservice.entities.User;
import com.example.simpledatingservice.entities.UsersLoginPrincipal;
import com.example.simpledatingservice.repository.UserLoginRepository;
import com.example.simpledatingservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private UserLoginRepository userLoginRepository;
    private PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    @Override
    @Transactional
    public UsersLoginPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersLogin usersLogin = userLoginRepository.findByEmail(username);
        if (usersLogin == null) {
            throw new UsernameNotFoundException(username);
        }
        UsersLoginPrincipal principal = new UsersLoginPrincipal(usersLogin);
        return principal;
    }
    @Transactional
    public void createNewUser(UserCredentialDTO userCredentials){
        String email = userCredentials.getEmail();
        String password = userCredentials.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        UsersLogin usersLogin = new UsersLogin(email, encodedPassword);
        User user = new User();
        user.setUsersLogin(usersLogin);
        usersLogin.setUser(user);
        userLoginRepository.save(usersLogin);
    }

    @Autowired
    public void setUserLoginRepository(UserLoginRepository userLoginRepository) {
        this.userLoginRepository = userLoginRepository;
    }
    @Autowired
    public void setPasswordEncoder(@Lazy PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
