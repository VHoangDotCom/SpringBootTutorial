package com.logingoogle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
public class SpringBootGoogleLoginApplication {

    @GetMapping
    public String Welcome(){
        return "Welcome to Google!";
    }

    @GetMapping("/user")
    public Principal User(Principal principal){
        System.out.println("User name: " + principal.getName());
        return principal;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGoogleLoginApplication.class, args);
    }

}
