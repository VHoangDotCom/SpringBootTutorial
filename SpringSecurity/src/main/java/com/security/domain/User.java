package com.security.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;

//   @OneToOne(
//           mappedBy = "user"
//   )
//   private Attachment avatar;

    @Lob
    private byte[] avatar;

    /*
    * FetchType.EAGER: When you load User table from database, it will automatically load Role table as well
    * FetchType.LAZY : When you load User table from database, it just loads User from DB, you have to call getAllRoles()
    * from User to get their roles
    * */

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();
}
