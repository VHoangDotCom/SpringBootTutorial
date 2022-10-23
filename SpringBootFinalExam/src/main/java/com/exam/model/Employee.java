package com.exam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "employees"
)
public class Employee {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long EmpID;

    private String Name;
    private String DateOfBirth;
    private double Wage;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "DepID",
            referencedColumnName = "DepID"
    )
    private Department department;
}
