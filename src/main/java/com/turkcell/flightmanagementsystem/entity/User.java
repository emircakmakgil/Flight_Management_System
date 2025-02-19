package com.turkcell.flightmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Date;
import java.util.Set;
import java.util.UUID;
//TODO:ŞİFRE SIFIRLAMA SERVİCE EKLENEBİLİR TELEFONLADA GİREBİLSİN
//TODO:EMAİLE ŞİFRE SIFIRLAMA KODU GİTSİN


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @UuidGenerator
    private UUID id;
    @Column(name = "first_name", unique = true)
    private String firstName;
    @Column(name = "last_name", unique = true)
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


    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn( name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles;

}
