package com.security;

import com.security.domain.Attachment;
import com.security.domain.Role;
import com.security.domain.User;
import com.security.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner runner(UserService userService) {
        return args -> {
           userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "John Deep", "john", "1234",null,new ArrayList<>()));
            userService.saveUser(new User(null, "Will Smith", "will", "1234",null, new ArrayList<>()));
            userService.saveUser(new User(null, "Jim Carry", "jim", "1234",null, new ArrayList<>()));
            userService.saveUser(new User(null, "viethoang2001gun@gmail.com", "hoang", "hoang",null, new ArrayList<>()));

            userService.addRoleToUser("john", "ROLE_USER");
            userService.addRoleToUser("will", "ROLE_MANAGER");
            userService.addRoleToUser("jim", "ROLE_ADMIN");
            userService.addRoleToUser("hoang", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("hoang", "ROLE_USER");
            userService.addRoleToUser("hoang", "ROLE_ADMIN");
            userService.addRoleToUser("will", "ROLE_ADMIN");
        };
    }
}
