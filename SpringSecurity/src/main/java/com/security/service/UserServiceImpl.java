package com.security.service;

import com.security.domain.Attachment;
import com.security.domain.Role;
import com.security.domain.User;
import com.security.repository.AttachmentRepository;
import com.security.repository.RoleRepository;
import com.security.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

@EnableScheduling
@Service @RequiredArgsConstructor @Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService{

    private final UserRepo userRepo;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AttachmentRepository attachmentRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailSenderService emailSenderService;

    /*
    ** CronTab Expression meaning
    * Seconds - Minutes - Hours - Day of month - Month - Day of week - Year
    *   0 0 12 * * ?	            Fire at 12:00 PM (noon) every day
        0 15 10 ? * *	            Fire at 10:15 AM every day
        0 15 10 * * ?	            Fire at 10:15 AM every day
        0 15 10 * * ? *	            Fire at 10:15 AM every day
        0 15 10 * * ? 2005	        Fire at 10:15 AM every day during the year 2005
        0 * 14 * * ?	            Fire every minute starting at 2:00 PM and ending at 2:59 PM, every day
        0 0/5 14 * * ?	            Fire every 5 minutes starting at 2:00 PM and ending at 2:55 PM, every day
        0 0/5 14,18 * * ?	        Fire every 5 minutes starting at 2:00 PM and ending at 2:55 PM, AND fire every 5 minutes starting at 6:00 PM and ending at 6:55 PM, every day
        0 0-5 14 * * ?	            Fire every minute starting at 2:00 PM and ending at 2:05 PM, every day
        0 10,44 14 ? 3 WED	        Fire at 2:10 PM and at 2:44 PM every Wednesday in the month of March
        0 15 10 ? * MON-FRI	        Fire at 10:15 AM every Monday, Tuesday, Wednesday, Thursday and Friday
        0 15 10 15 * ?	            Fire at 10:15 AM on the 15th day of every month
        0 15 10 L * ?	            Fire at 10:15 AM on the last day of every month
        0 15 10 ? * 6L	            Fire at 10:15 AM on the last Friday of every month
        0 15 10 ? * 6L 2002-2005	Fire at 10:15 AM on every last friday of every month during the years 2002, 2003, 2004, and 2005
        0 15 10 ? * 6#3	            Fire at 10:15 AM on the third Friday of every month
        0 0 12 1/5 * ?	            Fire at 12 PM (noon) every 5 days every month, starting on the first day of the month
        0 11 11 11 11 ?	            Fire every November 11 at 11:11 AM
     */

    /*
    * Thread.sleep()
    * 1000 : 1 second
    * 1000L : 1 second (L means it is a long literal. 1000 is an int.
    * It will automatically be promoted to long.
     */

//    @Scheduled(cron = "* * * * * *")
//    public void  triggerMail() throws MessagingException, InterruptedException {
//        emailSenderService.sendMailWithAttachment("viethoang2001gun@gmail.com",
//                "You login with wrong password !",
//                "Hi Viet Hoang",
//                "D:\\Themes\\Anime\\1.jpg");
//        Thread.sleep(1000L);
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user == null) {
            log.error("User not found in the database");
//            try {
//                triggerMail();
//            } catch (MessagingException ex){
//
//            } catch (InterruptedException x){
//
//            }
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}",username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database", user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public User saveUserWithAttachment(User user, MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try{
            if(fileName.contains("..")) {
                throw new Exception("Filename contains invalid path sequence"
                        +fileName);
            }
            Attachment attachment
                    = new Attachment(fileName,
                    file.getContentType(),
                    file.getBytes());
            attachmentRepository.save(attachment);
            user.setAvatar(attachment);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }catch (Exception ex) {
            throw new Exception("Could not save File: " + fileName);
        }
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        User user = userRepo.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }

    @Override
    public void sendSimpleEmail(String toEmail, String body, String subject) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("viethoang2001gun@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
        System.out.println("Mail Send...");
    }

    @Override
    public void sendMailWithAttachment(String toEmail, String body, String subject, String attachment) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper
                = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("viethoang2001gun@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource fileSystemResource =
                new FileSystemResource(new File(attachment));

        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);

        mailSender.send(mimeMessage);
        System.out.println("Mail Send...");
    }
}
