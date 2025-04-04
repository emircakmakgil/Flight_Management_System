package com.turkcell.flightmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Employee {
    @Id
    @UuidGenerator
    private UUID id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name="email", unique = true)
    private String email;
    private String password;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="created_at")
    private Date createdAt;
    @Column(name="updated_at")
    private Date updatedAt;
    @Column(name = "department")
    private String department;
    @Column(name = "position")
    private String position;
    @Column(name = "salary")
    private Double salary;
}