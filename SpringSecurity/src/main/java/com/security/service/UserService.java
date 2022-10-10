package com.security.service;

import com.security.domain.Role;
import com.security.domain.User;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User>getUsers();

    User saveUserWithAttachment(User user, MultipartFile file) throws Exception;

    void sendSimpleEmail(String toEmail, String body, String subject);
    void sendMailWithAttachment(String toEmail, String body, String subject, String attachment) throws MessagingException;
}
