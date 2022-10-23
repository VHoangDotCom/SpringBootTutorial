package com.security.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "attachments"
)
public class Attachment {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid" ,strategy = "uuid2")
    private String attachmentId;

    private String fileName;
    private String fileType;

    @Lob
    private byte[] data;

//    @OneToOne(
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY,
//            optional = false
//    )
//    @JoinColumn(
//            name = "user_id",
//            referencedColumnName = "id"
//    )
//    private User user;

    public Attachment(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

}
