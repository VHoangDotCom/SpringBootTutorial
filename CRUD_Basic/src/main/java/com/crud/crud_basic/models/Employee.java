package com.crud.crud_basic.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor//sinh constructor tự động
@NoArgsConstructor// constructor mặc định không có tham số đầu vào

/*
@Getter / @Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
* */
@Data
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;
}